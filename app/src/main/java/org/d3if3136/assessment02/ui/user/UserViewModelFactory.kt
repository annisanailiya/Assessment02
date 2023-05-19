package org.d3if3136.assessment02.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3136.assessment02.db.UserDao

class UserViewModelFactory (
    private val db: UserDao
    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                return UserViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }