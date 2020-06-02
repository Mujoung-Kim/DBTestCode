package company.domain.roomtestdb.data.databases

import androidx.room.Database
import androidx.room.RoomDatabase

import company.domain.roomtestdb.data.databases.entity.ContentEntry
import company.domain.roomtestdb.data.databases.entity.ScheduleEntry

@Database(entities = [ScheduleEntry::class, ContentEntry::class], version = 1)
abstract class AppDatabases : RoomDatabase() {

}