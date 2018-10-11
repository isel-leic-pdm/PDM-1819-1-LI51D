package pt.isel.pdm.i1819.li51d

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


const val COUNTER = "slb";


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = (savedInstanceState?.getString(COUNTER) ?: "0").toInt()

        counterLabel.text = counter.toString();

        plus.setOnClickListener {
            counterLabel.text = (++counter).toString()
        }

        minus.setOnClickListener {
            counterLabel.text = (--counter).toString()
        }

    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putString(COUNTER, counterLabel.text.toString())

    }
}
