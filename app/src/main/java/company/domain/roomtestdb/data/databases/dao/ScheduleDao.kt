package company.domain.roomtestdb.data.databases.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import company.domain.roomtestdb.data.databases.entity.ScheduleEntry

@Dao
interface ScheduleDao {
    @Query("select * from Schedules")
    fun getAll(): LiveData<List<ScheduleEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(scheduleEntry: ScheduleEntry)

    @Update
    fun update(scheduleEntry: ScheduleEntry)

    @Delete
    fun delete(scheduleEntry: ScheduleEntry)

    //  TODO add function in databases query

}