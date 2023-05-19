package org.d3if3136.assessment02.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3136.assessment02.db.UserDao

class HistoriViewModel(private val db: UserDao) : ViewModel() {
    val data = db.getLastUser()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}