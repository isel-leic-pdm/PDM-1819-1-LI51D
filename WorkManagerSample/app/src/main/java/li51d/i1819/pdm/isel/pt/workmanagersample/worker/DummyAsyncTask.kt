package li51d.i1819.pdm.isel.pt.workmanagersample.worker

import android.os.AsyncTask
import android.util.Log

private val TAG = DummyAsyncTask::class.java.simpleName

class DummyAsyncTask : AsyncTask<String, Void, Void>() {

    override fun doInBackground(vararg params: String): Void? {
        val name = params[0]
        Log.i(TAG, "Worker with name $name and started")
        WorkerImpl(name).work()
        return null
    }
}
