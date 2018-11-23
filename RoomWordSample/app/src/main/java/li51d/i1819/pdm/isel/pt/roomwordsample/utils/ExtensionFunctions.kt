package li51d.i1819.pdm.isel.pt.footballapp.utils

import android.app.Application
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import li51d.i1819.pdm.isel.pt.footballapp.FootballApplication
import li51d.i1819.pdm.isel.pt.footballapp.FootballDataRepository

val Application.footballDataRepository: FootballDataRepository
    get() = (this as FootballApplication).footballDataRepository

inline fun <reified T : ViewModel> FragmentActivity.viewModel(): T =
    ViewModelProviders.of(this, ViewModelFactory(this.application.footballDataRepository)).get(T::class.java)


class ViewModelFactory(val repository: FootballDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FootballDataRepository::class.java).newInstance(repository)
    }
}