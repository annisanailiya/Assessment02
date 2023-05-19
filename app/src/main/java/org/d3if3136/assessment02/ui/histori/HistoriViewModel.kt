package org.d3if3136.assessment02.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if3136.assessment02.db.UserDao

class HistoriViewModel(db: UserDao) : ViewModel() {
    val data = db.getLastUser()
}