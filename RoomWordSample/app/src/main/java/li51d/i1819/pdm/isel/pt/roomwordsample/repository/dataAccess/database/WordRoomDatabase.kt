package li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database

import android.os.AsyncTask
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

}



class PopulateDbAsync internal constructor(db: WordRoomDatabase) : AsyncTask<Void, Void, Void>() {

    private val mDao: WordDao

    init {
        mDao = db.wordDao()
    }

    override fun doInBackground(vararg params: Void): Void? {
        mDao.deleteAll()
        var word = Word("Hello")
        mDao.insert(word)
        word = Word("World")
        mDao.insert(word)
        return null
    }
}