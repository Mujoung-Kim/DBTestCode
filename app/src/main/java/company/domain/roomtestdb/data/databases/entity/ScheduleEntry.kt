package company.domain.roomtestdb.data.databases.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Schedules")
data class ScheduleEntry(
    @PrimaryKey
    @ColumnInfo(name = "schedule_name")
    val name: String,
    @ColumnInfo(name = "schedule_url")
    val url: String

) {
    @ColumnInfo(name = "schedule_id")
    var id: Int = 0

}