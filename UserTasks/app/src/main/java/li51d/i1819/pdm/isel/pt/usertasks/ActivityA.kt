package li51d.i1819.pdm.isel.pt.usertasks

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_a.*




class ActivityA : LoggingActivity() {
    val TAG = this.javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        Log.i(TAG,"Current intent: ${intent}")

        btnOk.setOnClickListener {
            val textStr = editText.text.toString()
            if(textStr.trim().length == 0) {
                Toast.makeText(this, "You must fill the edit text before launching the A1 activity", Toast.LENGTH_SHORT ).show()

                return@setOnClickListener
            }
            val intent = Intent(this, ActivityA1::class.java)
            intent.putExtra(EXTRA_KEY, textStr);

            startActivity(intent)
        }
    }
}
