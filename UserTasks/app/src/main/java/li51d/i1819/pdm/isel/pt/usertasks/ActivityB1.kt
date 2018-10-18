package li51d.i1819.pdm.isel.pt.usertasks

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_b1.*


class ActivityB1 : LoggingActivity() {
    val TAG = this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b1)

        Log.i(TAG, "Current intent: ${intent}")

        btnOk.setOnClickListener {
            val textStr = editText.text.toString()
            if (textStr.trim().length == 0) {
                Toast.makeText(this, "You must fill the edit text before leaving the B1 activity", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent()
            intent.putExtra(EXTRA_KEY, textStr);

            setResult(Activity.RESULT_OK, intent)
            Log.i(TAG,"User exited activity B1 with OK button and text '${textStr}'")
            finish()
        }

        btnCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            Log.i(TAG,"User exited anctivity B1 with CANCEL button")
            finish()
        }
    }
}
