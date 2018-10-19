package isel.adeetc.pdm.threadingmodel

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

lateinit var theActivity: MainActivity

class MainActivity : AppCompatActivity() {
    val TAG = "ThreadingModel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        theActivity = this
        Log.v(TAG, "onCreate for ${hashCode()} on Thread ${Thread.currentThread().id} is working hard")

        hitMeButton.setOnClickListener {
            val work = object: AsyncTask<Unit, Unit, String>() {
                override fun doInBackground(vararg params: Unit?): String {

                    Log.v(TAG, "Thread ${Thread.currentThread().id} is working hard")
                    Thread.sleep(10000)
                    Log.v(TAG, "Thread ${Thread.currentThread().id} completed hard work")
                    return "Work Completed"
                }

                override fun onPostExecute(result: String?) {
                    Log.v(TAG, "Thread ${Thread.currentThread().id} is displaying result")
                    Log.v(TAG, "Activity is ${this@MainActivity.hashCode()}")
                    theActivity.msgTextView.text = result
                }
            }

            Log.v(TAG, "Thread ${Thread.currentThread().id} dispatching work")
            work.execute()
            Log.v(TAG, "Thread ${Thread.currentThread().id} dispatched work")
        }
    }
}
