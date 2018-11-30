package li51d.i1819.pdm.isel.pt.workmanagersample.worker

import android.util.Log
import android.os.Process

private val TAG = DummyWorker::class.java.simpleName

class WorkerImpl(val name: String) {
    fun work() {
        Log.i(TAG, "WorkerImpl with id $name started working...")
        Log.i(TAG, "ThreadId: ${Thread.currentThread().id}. ProcessId: ${Process.myPid()}")

        Thread.sleep(5000)
        Log.i(TAG, "WorkerImpl with id $name finished work!")
    }
}