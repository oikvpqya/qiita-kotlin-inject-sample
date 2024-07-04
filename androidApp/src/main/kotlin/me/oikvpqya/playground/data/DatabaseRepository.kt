package me.oikvpqya.playground.data

import androidx.room.immediateTransaction
import androidx.room.useWriterConnection
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.tatarka.inject.annotations.Inject

interface DatabaseRepository {
    fun get(): Flow<ImmutableList<String>>
    suspend fun insert(string: String)
    suspend fun insert(strings: List<String>)
}

@Inject
class DatabaseRepositoryImpl(
    private val database: AppDatabase,
) : DatabaseRepository {

    override fun get(): Flow<ImmutableList<String>> {
        return database.table1Dao().get()
            .map { it.takeLast(20).toImmutableList() }
    }

    override suspend fun insert(string: String) {
        database.table1Dao().insert(string)
    }

    override suspend fun insert(strings: List<String>) {
        database.useWriterConnection { transactor ->
            transactor.immediateTransaction {
                strings.forEach { string ->
                    database.table1Dao().insert(string)
                }
            }
            // Manually triggers invalidation
            database.invalidationTracker.refreshAsync()
        }
    }
}
