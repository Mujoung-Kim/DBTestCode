package company.domain.roomtestdb.data.databases.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "Contents", indices = [Index(value = ["content_name"], unique = true)])
data class ContentEntry(
    @PrimaryKey
    @ColumnInfo(name = "content_name")
    val name: String,
    @ColumnInfo(name = "content_type")
    val type: String

) {
    @ColumnInfo(name = "content_number")
    var number: Long = 0
    @ColumnInfo(name = "content_dir")
    var directory: String? = null
    @ColumnInfo(name = "content_count")
    var count: Int = 0

}

//  how to setting unique column.
//  @Entity(tableName = "input this", indices = [Index(value = ["input column_name"], unique = true)])