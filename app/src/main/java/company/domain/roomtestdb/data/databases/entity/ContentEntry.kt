package company.domain.roomtestdb.data.databases.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contents")
data class ContentEntry(
    @ColumnInfo(name = "content_name")
    val name: String,
    @ColumnInfo(name = "content_type")
    val type: String,
    @ColumnInfo(name = "content_count")
    val count: Int

) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "content_id")
    var id: Int = 0
    @ColumnInfo(name = "content_dir")
    var directory: String? = null

}