package com.go.lib_base1.network.okhttp

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.go.lib_base1.network.NetworkConstants
import com.go.lib_base1.network.PrinterNetwork
import com.go.lib_base1.network.interfaces.ICallback
import com.go.lib_base1.network.interfaces.IHttpProcessor
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * okhttp网络框架
 */
class OKHttpProcessor(context: Context) : IHttpProcessor {

    object Constant {
        const val contentTypeKey = "Content-Type"
        const val contentType = "application/json; charset=utf-8"
        const val acceptKey = "Accept"
        const val accept = "application/json"
    }
    private val tag = OKHttpProcessor::class.java.name
    private var okHttpClient: OkHttpClient? = null
    private val mHandler: Handler

    init {
        okHttpClient = OkHttpClient()
        val cacheFile = File(context.cacheDir!!.path + File.separator + "http_cache" + File.separator)
        val cacheSize = 10 * 1024 * 1024
        val okBuilder = OkHttpClient.Builder()
        val cache = Cache(cacheFile, cacheSize.toLong())
        okBuilder.cache(cache)
        okBuilder.readTimeout(20, TimeUnit.SECONDS)
        okBuilder.connectTimeout(10, TimeUnit.SECONDS)
        okBuilder.writeTimeout(20, TimeUnit.SECONDS)
        okHttpClient = okBuilder.build()
        mHandler = Handler(Looper.getMainLooper())
    }

    override fun _post(url: String, params: Map<String, Any>, callback: ICallback) {
        PrinterNetwork.e(tag, "URL:$url")
        PrinterNetwork.e(tag, "params:$params")
        val requestBody = appendBody(params)
        val request = getRequestBuilder()
            .url(NetworkConstants.BASE_URL + url)
            .post(requestBody)
            .build()
        okHttpClient!!.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                mHandler.post {
                    PrinterNetwork.e(tag, "url:" + url + "    onFailure------->" + e.message)
                    callback.onFailure(e.message.toString())
                }
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                PrinterNetwork.e(
                    tag,
                    "url:" + url + "onResponse----response.code()--->" + response.code
                )
                if (response.isSuccessful) {
                    val result = response.body!!.string()
                    PrinterNetwork.e(tag, "url:" + url + "onResponse----isSuccessful(--->" + result)
                    mHandler.post { callback.onSuccess(result) }
                } else {
                    mHandler.post {
                        PrinterNetwork.e(
                            tag,
                            "url:" + url + "onResponse----Failure--->" + response.message.toString()
                        )
                        callback.onFailure(response.message.toString())
                    }
                }
            }
        })
    }


    override fun _get(url: String, params: Map<String, Any>, callback: ICallback) {
        val request = getRequestBuilder()
            .url(NetworkConstants.BASE_URL + url)
            .get()
            .build()
        okHttpClient!!.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                mHandler.post {
                    PrinterNetwork.e(tag, "----" + e.message.toString())
                    callback.onFailure(e.message.toString())
                }
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val result = response.body!!.string()
                    PrinterNetwork.e(tag, "----$result")
                    mHandler.post { callback.onSuccess(result) }
                } else {
                    mHandler.post { callback.onFailure(response.message.toString()) }
                }
            }
        })
    }

    override fun _file(file: File, callback: ICallback) {
        PrinterNetwork.e(tag, "file.Name()" + file.name)
        val fileBody = file.asRequestBody("image/png".toMediaTypeOrNull())
        val requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("upFile", file.name, fileBody)
            //  .addFormDataPart("application/octet-stream", file.getName(), fileBody)
            //.addFormDataPart("upFile", file.getName(), RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), file))
            .build()
        val request = getRequestBuilder()
            .url(NetworkConstants.UPLOAD_URL)
            .post(requestBody)
            .build()
        okHttpClient!!.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                mHandler.post {
                    PrinterNetwork.e(tag, "----" + e.message.toString())
                    callback.onFailure(e.message.toString())
                }
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val result = response.body!!.string()
                    PrinterNetwork.e(tag, "----$result")
                    mHandler.post { callback.onSuccess(result) }
                } else {
                    mHandler.post {
                        try {
                            callback.onFailure(
                                response.message.toString()
                            )
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        })
    }


    private fun appendBody(params: Map<String, Any>?): RequestBody {
        val body = FormBody.Builder()
        if (params == null || params.isEmpty())
            return body.build()
        for ((key, value) in params) {
            body.add(key, value.toString())
        }
        return body.build()
    }


    /**
     * 请求配置
     *
     * @return
     */
    private fun getRequestBuilder(): Request.Builder {
        return Request.Builder()
            .addHeader(Constant.contentTypeKey, Constant.contentType)
            .addHeader(Constant.acceptKey, Constant.accept)
    }
}
