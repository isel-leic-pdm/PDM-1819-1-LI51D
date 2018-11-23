package li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "words")
class Word(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    val word: String
)

