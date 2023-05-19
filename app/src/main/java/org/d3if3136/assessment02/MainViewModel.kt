package org.d3if3136.assessment02

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3136.assessment02.model.HasilInput

class MainViewModel : ViewModel() {

    private val hasilInput = MutableLiveData<HasilInput?>()

    fun welcome(nama: String) {
        val lanjut = nama
        hasilInput.value = HasilInput(lanjut)
    }

}