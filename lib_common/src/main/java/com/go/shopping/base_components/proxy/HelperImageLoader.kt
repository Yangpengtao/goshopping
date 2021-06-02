package com.go.shopping.base_components.proxy

import android.net.Uri
import android.widget.ImageView
import com.go.lib_base1.image.interfaces.IImageLoaderProcessor

object HelperImageLoader :
    IImageLoaderProcessor {
    override fun loadNormalImage(imageView: ImageView, uri: Uri) {
        mHttpProcessor!!.loadNormalImage(imageView, uri)
    }

    override fun loadNormalImage(imageView: ImageView, url: String) {
        mHttpProcessor!!.loadNormalImage(imageView, url)
    }

    override fun loadCircleImage(imageView: ImageView, url: String) {
        mHttpProcessor!!.loadCircleImage(imageView, url)
    }

    override fun loadRoundImage(imageView: ImageView, url: String) {
        mHttpProcessor!!.loadRoundImage(imageView, url)
    }

    private var mHttpProcessor: IImageLoaderProcessor? = null

    fun init(httpProcessor: IImageLoaderProcessor) {
        mHttpProcessor = httpProcessor
    }


}