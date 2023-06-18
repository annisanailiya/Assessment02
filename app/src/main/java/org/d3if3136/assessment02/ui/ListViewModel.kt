package org.d3if3136.assessment02.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.model.Pahlawan
import org.d3if3136.assessment02.network.ApiStatus
import org.d3if3136.assessment02.network.PahlawanApi
import org.d3if3136.assessment02.network.UpdateWorker
import java.util.concurrent.TimeUnit

class ListViewModel : ViewModel() {

    private val data = MutableLiveData<List<Pahlawan>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(PahlawanApi.service.getPahlawan())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("ListViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }
    
    fun getData(): LiveData<List<Pahlawan>> = data

    fun getStatus(): LiveData<ApiStatus> = status

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }
}