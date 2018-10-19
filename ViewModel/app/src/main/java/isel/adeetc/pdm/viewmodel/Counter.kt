package isel.adeetc.pdm.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log

data class Counter(val modulo: Int=10, var value: Int = 0): ViewModel() {
    val TAG = this.javaClass.simpleName
    operator fun inc(): Counter {
        value = (value + 1) % modulo
        return this
    }

    operator fun dec(): Counter {
        value = if (value == 0) modulo - 1 else value - 1
        return this
    }

    override fun onCleared() {
        Log.i(TAG, "onCleared called")
    }
}