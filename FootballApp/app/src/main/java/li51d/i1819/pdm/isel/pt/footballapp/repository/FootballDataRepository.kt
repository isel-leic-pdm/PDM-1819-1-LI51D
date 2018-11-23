package li51d.i1819.pdm.isel.pt.footballapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData.FootballApi
import li51d.i1819.pdm.isel.pt.footballapp.repository.domain.Competition
import li51d.i1819.pdm.isel.pt.footballapp.repository.domain.toCompetition

class FootballDataRepository(private val footballApi: FootballApi) {

    fun getCompetitions() : LiveData<Array<Competition>> {
        val competitions = MutableLiveData<Array<Competition>>()

        footballApi.getCompetitions {
            competitions.value = it.map { it.toCompetition() }.toTypedArray()
        }
        return competitions
    }
}