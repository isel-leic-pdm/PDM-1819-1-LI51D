package li51d.i1819.pdm.isel.pt.workmanagersample

import android.os.Bundle
import android.os.Process
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import li51d.i1819.pdm.isel.pt.workmanagersample.worker.DummyWorker
import li51d.i1819.pdm.isel.pt.workmanagersample.worker.WorkerImpl
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

private val TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun startWork(view: View) {
        Log.i(TAG, "Main activity - ThreadId: ${Thread.currentThread().id}. ProcessId: ${Process.myPid()}")

        val myData: Data = Data.Builder().putString("NAME", "worker1").build()
        val dummyWorker1: OneTimeWorkRequest =
            OneTimeWorkRequestBuilder<DummyWorker>()
                .setInitialDelay(10, TimeUnit.SECONDS)
                .setInputData(myData)
                .build()


        Executors.newSingleThreadExecutor().submit({
            Log.i(TAG, "Waiting to start work...")
            Thread.sleep(10000)
            Log.i(TAG, "Start work")
            WorkerImpl("worker1-ThreadPool").work()
        })


//        val dummyWorker2: OneTimeWorkRequest =
//            OneTimeWorkRequestBuilder<DummyWorker>()
//                //.setInputData(myData)
//                .build()
//        val dummyWorker3: OneTimeWorkRequest =
//            OneTimeWorkRequestBuilder<DummyWorker>()
//                //.setInputData(myData)
//                .build()
        WorkManager.getInstance().enqueue(dummyWorker1)


//        WorkManager.getInstance().enqueue(dummyWorker2)
//        WorkManager.getInstance().enqueue(dummyWorker3)

    }
}
