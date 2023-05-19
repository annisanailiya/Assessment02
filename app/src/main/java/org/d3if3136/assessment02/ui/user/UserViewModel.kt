package org.d3if3136.assessment02.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3136.assessment02.db.UserDao
import org.d3if3136.assessment02.db.UserEntity
import org.d3if3136.assessment02.model.HasilInput

class UserViewModel(private val db: UserDao) : ViewModel() {

    private val hasilInput = MutableLiveData<HasilInput?>()

    fun welcome(nama: String) {
        val lanjut = nama
        hasilInput.value = HasilInput(lanjut)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataUser = UserEntity(
                    nama = nama
                )
                db.insert(dataUser)
            }
        }
    }

}