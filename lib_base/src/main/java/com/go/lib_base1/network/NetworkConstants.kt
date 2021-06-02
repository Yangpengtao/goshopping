package com.go.lib_base1.network

object NetworkConstants{
    val BASE_URL = getBaseUrl()
    const val UPLOAD_URL = "http://file.oomall.com/api/upload"

    private fun getBaseUrl(): String {
        return if (true) {
            "http://api-canteen.oomall.com/v265/api/"
        } else {
            "http://api-canteen.oomall.com/v265/api/"
        }
    }


}

