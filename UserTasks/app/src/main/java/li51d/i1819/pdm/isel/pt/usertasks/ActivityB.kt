package li51d.i1819.pdm.isel.pt.usertasks

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b.*


const val REQ_CODE = 2;




class ActivityB : LoggingActivity() {
    val TAG = ActivityB::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        btnLaunch.setOnClickListener {
            startActivityForResult(Intent(this, ActivityB1::class.java), REQ_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i(TAG,"onActivityResult called with requestCode ${requestCode} and resultCode ${resultCode}")
        if(requestCode == REQ_CODE) {
            when(resultCode) {
                Activity.RESULT_OK -> receivedText.text = data?.getStringExtra(EXTRA_KEY)
                Activity.RESULT_CANCELED -> Toast.makeText(this, "The action was canceled by the user. No text was received", Toast.LENGTH_SHORT).show()
                else -> throw IllegalStateException()

            }
        } else {
            Log.e(TAG, "Something really weired happened. A result was recived from an unknown request")
            throw throw IllegalStateException()
        }
    }
}
