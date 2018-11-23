package li51d.i1819.pdm.isel.pt.footballapp.repository.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData.CompetitionDto


fun CompetitionDto.toCompetition() : Competition = Competition(this.id, this.name, this.area.name, this.code)


fun <T> T.toLiveData() : LiveData<T> {
    val mutableLiveData = MutableLiveData<T>()
    mutableLiveData.value = this
    return mutableLiveData
}
