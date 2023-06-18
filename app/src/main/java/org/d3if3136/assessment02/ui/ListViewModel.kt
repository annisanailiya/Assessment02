package org.d3if3136.assessment02.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.model.Pahlawan

class ListViewModel : ViewModel() {

    private val data = MutableLiveData<List<Pahlawan>>()

    init {
        data.value = initData()
    }

    private fun initData(): List<Pahlawan> {
        return listOf(
            Pahlawan("Soekarno ", "Surabaya, Jawa Timur", "Soekarno adalah Proklamator Kemerdekaan Indone...", R.drawable.soekarno),
            Pahlawan("Mohammad Hatta", "Bukittinggi, Sumatera Barat", "Muhammad Hatta, atau Dr. Mohammad Hatta, ad...", R.drawable.mohammadhatta),
            Pahlawan("Sultan Hasanuddin", "Gowa, Sulawesi Selatan", "Sultan Hasanuddin adalah pahlawan nasional ...", R.drawable.sultanhasanuddin),
            Pahlawan("Cut Nyak Dien", "Aceh, Sumatera Utara", "Cut Nyak Dien adalah pahlawan nasional Indones...", R.drawable.cutnyakdien),
            Pahlawan("Diponegoro", "Yogyakarta, Jawa Tengah", "Diponegoro adalah pahlawan nasional Indones...", R.drawable.diponegoro),
            Pahlawan("Tan Malaka", "Pandan Gadang, Sumatera Barat", "Tan Malaka adalah seorang tokoh revolusione...", R.drawable.tanmalaka),
            Pahlawan("Ki Hajar Dewantara", "Yogyakarta, Jawa Tengah", "Ki Hajar Dewantara adalah seorang pendidik ...", R.drawable.kihajardewantara),
            Pahlawan("RA. Kartini", "Jepara, Jawa Tengah", "R.A. Kartini adalah seorang pahlawan nasion...", R.drawable.rakartini),
            Pahlawan("Teuku Umar", "Meulaboh, Aceh", "Teuku Umar adalah pahlawan nasional Indones...", R.drawable.teukuumar),
            Pahlawan("Agus Salim", "Padang Panjang, Sumatera Barat", "Agus Salim adalah seorang tokoh nasional In...", R.drawable.agusalim),
        )
    }
    fun getData(): LiveData<List<Pahlawan>> = data
}