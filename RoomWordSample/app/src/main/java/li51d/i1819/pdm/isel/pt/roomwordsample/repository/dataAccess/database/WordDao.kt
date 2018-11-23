package li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * from words ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM words")
    fun deleteAll()
}