package li51d.i1819.pdm.isel.pt.roomwordsample.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.Word
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.WordDao


class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    fun insert(word: Word) {
        InsertAsyncTask().execute(word);
    }

    inner private class InsertAsyncTask : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            wordDao.insert(params[0])
            return null
        }
    }
}

