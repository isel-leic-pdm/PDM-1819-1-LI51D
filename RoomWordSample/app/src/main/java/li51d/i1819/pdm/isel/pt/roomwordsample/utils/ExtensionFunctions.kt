package li51d.i1819.pdm.isel.pt.roomwordsample.utils

import android.app.Application
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import li51d.i1819.pdm.isel.pt.roomwordsample.WordApplication
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.WordRepository

val Application.wordsRepository: WordRepository
    get() = (this as WordApplication).wordsRepository

inline fun <reified T : ViewModel> FragmentActivity.viewModel(): T =
    ViewModelProviders.of(this, ViewModelFactory(this.application.wordsRepository)).get(T::class.java)


class ViewModelFactory(val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WordRepository::class.java).newInstance(repository)
    }
}