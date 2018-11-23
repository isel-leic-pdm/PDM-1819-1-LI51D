package li51d.i1819.pdm.isel.pt.footballapp.utils

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

object HttpRequests {
    val TAG: String = HttpRequests::class.java.simpleName
    private lateinit var queue: RequestQueue
    val mapper = jacksonObjectMapper()

    init {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    fun get(url: String, headers: Map<String, String> = mapOf() ,cb: (String) -> Unit) {
        request(Request.Method.GET, url, headers, cb)
    }

    inline fun <reified T> getJsonDto(url: String, headers: Map<String, String> = mapOf() , crossinline cb: (T) -> Unit) {
        request(Request.Method.GET, url, headers) {
            Log.i(TAG, "json data to parse: $it")
            val dto = mapper.readValue<T>(it)
            Log.i(TAG, "dto created: $dto")
            cb(dto)
        }
    }

    fun init(context: Context) {
        // Instantiate the RequestQueue.
        Log.i(TAG, "Init called")
        queue = Volley.newRequestQueue(context)
    }


    @PublishedApi
    internal fun request(
        method: Int,
        url: String,
        headers: Map<String, String>,
        cb: (String) -> Unit
    ) {

        val req = HeadersStringRequest(
            method, url, headers,
            onResponse(cb),
            onError()
        )
        queue.add(req)
    }

    private fun onResponse(cb: (String) -> Unit): Response.Listener<String> = Response.Listener { str -> cb(str) }

    private fun onError(): Response.ErrorListener = Response.ErrorListener {
            err -> throw Exception(err.message)
    }


    class HeadersStringRequest(method: Int,
                               url: String,
                               val hdrs: Map<String, String>,
                               listener: Response.Listener<String>,
                               errorListener: Response.ErrorListener
    ) : StringRequest(method,url, listener, errorListener ) {

        override fun getHeaders(): MutableMap<String, String>  = hdrs.toMutableMap()

    }

}