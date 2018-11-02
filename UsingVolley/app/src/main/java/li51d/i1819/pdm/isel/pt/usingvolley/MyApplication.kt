package li51d.i1819.pdm.isel.pt.usingvolley

import android.app.Application
import android.util.Log
import li51d.i1819.pdm.isel.pt.usingvolley.data.HttpRequests

class MyApplication: Application() {
    val TAG: String = MyApplication::class.java.simpleName;
    override fun onCreate() {
        super.onCreate()

        Log.i(TAG, "onCreate")
        HttpRequests.init(this)

    }
}