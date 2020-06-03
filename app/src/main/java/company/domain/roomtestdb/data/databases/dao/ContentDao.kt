package company.domain.roomtestdb.data.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import company.domain.roomtestdb.data.databases.entity.ContentEntry

@Dao
interface ContentDao {
    @Query("select * from contents")
    fun getAll(): LiveData<List<ContentEntry>>

    //  insert & update function.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contentEntry: ContentEntry)

    @Update
    suspend fun update(contentEntry: ContentEntry)

    @Delete
    fun delete(contentEntry: ContentEntry)

    //  TODO add function in databases query
    /*@Query("select count(content_number) from Contents")
    fun emptyContents(): LiveData<List<ContentEntry>>*/

//    @Query("select content_number from contents where content_number = 0")
//    fun increment(contentEntry: ContentEntry)

    @Query("select content_name from Contents")
    fun extractName(): LiveData<ArrayList<ContentEntry>>

}