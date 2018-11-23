package li51d.i1819.pdm.isel.pt.footballapp.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import li51d.i1819.pdm.isel.pt.footballapp.FootballDataRepository
import li51d.i1819.pdm.isel.pt.footballapp.repository.domain.Competition

class CompetitionsActivityViewModel(footballRepo: FootballDataRepository) : ViewModel() {
    val competitions: LiveData<Array<Competition>> = footballRepo.getCompetitions()
}