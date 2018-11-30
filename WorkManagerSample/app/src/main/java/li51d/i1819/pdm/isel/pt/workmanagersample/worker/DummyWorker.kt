package li51d.i1819.pdm.isel.pt.workmanagersample.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

private val TAG = DummyWorker::class.java.simpleName

class DummyWorker(context : Context, params : WorkerParameters)
        : Worker(context, params) {
        val name = inputData.getString("NAME") ?: "No name provided"

        private val workerImpl = WorkerImpl(name)

        override fun doWork(): Result {
                Log.i(TAG, "Worker with name $name and id $id started")
                workerImpl.work()
                return Result.SUCCESS

        }

}