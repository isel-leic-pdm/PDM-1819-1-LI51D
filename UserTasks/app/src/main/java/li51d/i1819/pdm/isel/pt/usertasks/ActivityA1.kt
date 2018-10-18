package li51d.i1819.pdm.isel.pt.usertasks

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_a1.*



class ActivityA1 : LoggingActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a1)

        textView.text = intent.getStringExtra(EXTRA_KEY)

    }
}
