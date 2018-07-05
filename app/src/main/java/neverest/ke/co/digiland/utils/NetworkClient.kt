package neverest.ke.co.digiland.utils

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams

class NetworkClient {
    private val BASE_URL=CoreUtils.base_url
    private val client=AsyncHttpClient(true,80,443)
    init {
        client.addHeader("Accept", "application/json")
    }


    operator fun get(url: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler)
    }

    fun post(url: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler)
    }

    private fun getAbsoluteUrl(relativeUrl: String): String {
        return BASE_URL + relativeUrl
    }
}