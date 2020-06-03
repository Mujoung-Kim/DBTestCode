package company.domain.roomtestdb.design.layout

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room

import company.domain.roomtestdb.data.databases.AppDatabases
import company.domain.roomtestdb.data.databases.entity.ContentEntry
import company.domain.roomtestdb.data.databases.entity.ScheduleEntry

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TestViewModel(application: Application) : AndroidViewModel(application) {
    private val database = Room.databaseBuilder(application, AppDatabases::class.java, "Test.db").build()
    var scheduleResult: LiveData<List<ScheduleEntry>>
    var contentResult: LiveData<List<ContentEntry>>
    var scheduleName: String? = null
    var scheduleUrl: String = "https://www.naver.com"
    var contentName: String? = null
    var contentType: String? = null

    var scheduleUpdate: ScheduleEntry = ScheduleEntry("sancho", "manchester united")
    var contentUpdate: ContentEntry = ContentEntry("bebe", "fuck")
    var scheduleNameList: LiveData<ArrayList<ScheduleEntry>>
    var contentNameList: LiveData<ArrayList<ContentEntry>>

    init {
        scheduleResult = scheduleAll()
        contentResult = contentAll()
        scheduleNameList = scheduleName()
        contentNameList = contentName()

    }

    //  Schedules databases access
    fun scheduleAll(): LiveData<List<ScheduleEntry>> = database.ScheduleDao().getAll()

//    fun scheduleInsert(scheduleEntry: ScheduleEntry) {
//        viewModelScope.launch {
//            database.ScheduleDao().insert(scheduleEntry)
//
//        }
//    }

    fun scheduleInsert(name: String, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            database.ScheduleDao().insert(ScheduleEntry(name, url))
            Log.d("Log", "insert complete")

        }
    }

    fun scheduleUpdate(scheduleEntry: ScheduleEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            database.ScheduleDao().update(scheduleEntry)
            Log.d("Log", "update complete")
            Log.d("Log", "entry - $scheduleEntry")

        }
    }

    fun scheduleName(): LiveData<ArrayList<ScheduleEntry>> = database.ScheduleDao().extractName()

    //  Contents database access
    fun contentAll(): LiveData<List<ContentEntry>> = database.ContentDao().getAll()

//    fun contentInsert(contentEntry: ContentEntry) {
//        viewModelScope.launch(Dispatchers.IO) {
//            database.ContentDao().insert(contentEntry)
//
//        }
//    }

    fun contentInsert(name: String, type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            database.ContentDao().insert(ContentEntry(name, type))

        }
    }

    fun contentUpdate(contentEntry: ContentEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            database.ContentDao().update(contentEntry)

        }
    }

//    fun contentDelete(contentEntry: ContentEntry) {
//        viewModelScope.launch(Dispatchers.IO) {
//            database.ContentDao().delete(contentEntry)
//
//        }
//    }

    fun contentName(): LiveData<ArrayList<ContentEntry>> = database.ContentDao().extractName()

    fun addDownloadList() {
        scheduleNameList = scheduleName()
        contentNameList = contentName()
    }

}