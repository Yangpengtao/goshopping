package com.go.shopping.lib_base.network

object NetworkConstants{
    val BASE_URL = getBaseUrl()
    const val UPLOAD_URL = "http://file.oomall.com/api/upload"

    //后期可考虑移到gradle里
    private fun getBaseUrl(): String {
        return if (1==1) {
            "http://api-canteen.oomall.com/v265/api/"
        } else {
            "http://api-canteen.oomall.com/v265/api/"
        }
    }


}

