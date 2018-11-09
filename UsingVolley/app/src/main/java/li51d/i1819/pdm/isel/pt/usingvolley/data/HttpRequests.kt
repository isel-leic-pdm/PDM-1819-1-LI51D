package li51d.i1819.pdm.isel.pt.usingvolley.data

import android.content.Context
import android.support.annotation.Nullable
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

object HttpRequests {
    val TAG: String = HttpRequests::class.java.simpleName;

    private lateinit var queue: RequestQueue

    public fun init(context: Context) {
        // Instantiate the RequestQueue.
        Log.i(TAG, "Init called")
        queue = Volley.newRequestQueue(context)
    }

    private fun request(
        method: Int,
        url: String,
        headers: Map<String, String>,
        cb: (String) -> Unit
    ) {

        val req = HeadersStringRequest(
            Request.Method.GET, url, headers,
            onResponse(cb),
            onError()
        )
        queue.add(req)
    }


    fun get(url: String, headers: Map<String, String> = mapOf() ,cb: (String) -> Unit) {
        request(Request.Method.GET, url, headers, cb)
    }

    private fun onResponse(cb: (String) -> Unit): Response.Listener<String> = Response.Listener { str -> cb(str) }

    private fun onError(): Response.ErrorListener = Response.ErrorListener { err -> throw Exception(err.message) }


    class HeadersStringRequest(method: Int,
                               url: String,
                               val hdrs: Map<String, String>,
                               listener: Response.Listener<String>,
                               errorListener: Response.ErrorListener
    ) : StringRequest(method,url, listener, errorListener ) {

        override fun getHeaders(): MutableMap<String, String>  = hdrs.toMutableMap()

    }

}