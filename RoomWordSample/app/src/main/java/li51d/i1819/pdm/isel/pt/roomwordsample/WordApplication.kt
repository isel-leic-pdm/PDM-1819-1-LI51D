package li51d.i1819.pdm.isel.pt.roomwordsample

import android.app.Application
import android.util.Log
import androidx.room.Room
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.WordRepository
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.PopulateDbAsync
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.WordRoomDatabase

class WordApplication: Application() {
    val TAG: String = WordApplication::class.java.simpleName;

    lateinit var wordsRepository: WordRepository
        private set

    override fun onCreate() {
        super.onCreate()

        Log.i(TAG, "onCreate application")

        var wordRoomDatabase =
            Room.databaseBuilder(this, WordRoomDatabase::class.java, "Word_database")
            //Room.inMemoryDatabaseBuilder(this, WordRoomDatabase::class.java)
            .build()

        PopulateDbAsync(wordRoomDatabase).execute()

        wordsRepository = WordRepository(wordRoomDatabase.wordDao())
    }
}