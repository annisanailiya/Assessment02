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
import org.d3if3136.assessment02.model.welcome

class UserViewModel(private val db: UserDao) : ViewModel() {

    private val hasilInput = MutableLiveData<HasilInput?>()

    fun welcome(nama: String) {

        val dataUser = UserEntity(
            nama = nama
        )
        hasilInput.value = dataUser.welcome()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataUser)
            }
        }
    }

}