package li51d.i1819.pdm.isel.pt.usertasks

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity2Btn.setOnClickListener {
            val intent = Intent(applicationContext, Activity2::class.java)


            startActivity(intent)
        }

        activity3Btn.setOnClickListener {

        }
    }
}
