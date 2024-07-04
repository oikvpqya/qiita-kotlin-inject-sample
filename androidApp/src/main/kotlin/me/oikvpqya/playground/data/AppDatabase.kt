package me.oikvpqya.playground.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Database(
    entities = [
        Table1Entity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun table1Dao(): Table1Dao
}

@Dao
interface Table1Dao {

    @Query(
        value = """
        SELECT string FROM table1
    """
    )
    fun get(): Flow<List<String>>

//    @Query(
//        value = """
//        INSERT INTO table1
//        VALUES (:string) ON CONFLICT (string) DO NOTHING
//    """
    @Query(
        value = """
        INSERT INTO table1
        VALUES (:string)
    """
    )
    suspend fun insert(string: String)
}

@Entity(
    tableName = "table1",
)
data class Table1Entity(
    @PrimaryKey val string: String,
)
