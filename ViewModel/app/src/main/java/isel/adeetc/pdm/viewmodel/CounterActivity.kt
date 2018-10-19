package isel.adeetc.pdm.viewmodel

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import isel.adeetc.pdm.kotlinx.getViewModel
import kotlinx.android.synthetic.main.activity_main.*

const val counterKey = "counterValue"

class CounterActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName

    private lateinit var viewModel: Counter

    private fun updateUI(counter: Counter) {
        counterView.text = counter.value.toString()
    }

    override fun onCreate(savedState: Bundle?) {
        super.onCreate(savedState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(Counter::class.java)

        Log.i(TAG,"Activity instance hashCode = ${this.hashCode()}")
        Log.i(TAG,"Counter instance hashCode = ${viewModel.hashCode()}")

//        viewModel = this.getViewModel(counterKey) { Counter(5) }
        updateUI(viewModel)
//
        incButton.setOnClickListener { updateUI(++viewModel) }
        decButton.setOnClickListener { updateUI(--viewModel) }
    }

}
