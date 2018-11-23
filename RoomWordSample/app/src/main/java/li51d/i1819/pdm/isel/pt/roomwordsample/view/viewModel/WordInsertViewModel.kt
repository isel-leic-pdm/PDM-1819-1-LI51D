package li51d.i1819.pdm.isel.pt.roomwordsample.view.viewModel

import androidx.lifecycle.ViewModel
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.WordRepository
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.Word


class WordInsertViewModel(private val repository: WordRepository) : ViewModel() {
    fun insert(word: Word) {
        repository.insert(word)
    }
}