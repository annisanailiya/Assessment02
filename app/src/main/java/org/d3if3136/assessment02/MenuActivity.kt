package org.d3if3136.assessment02

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3136.assessment02.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }
    }

    private fun getData(): List<Pahlawan> {
        return listOf(
            Pahlawan("Soekarno ", "Surabaya, Jawa Timur"),
            Pahlawan("Mohammad Hatta", "Bukittinggi, Sumatera Barat"),
            Pahlawan("Sultan Hasanuddin", "Gowa, Sulawesi Selatan"),
            Pahlawan("Cut Nyak Dien", "Aceh, Sumatera Utara"),
            Pahlawan("Diponegoro", "Yogyakarta, Jawa Tengah"),
            Pahlawan("Tan Malaka", "Pandan Gadang, Sumatera Barat"),
            Pahlawan("Ki Hajar Dewantara", "Yogyakarta, Jawa Tengah"),
            Pahlawan("RA. Kartini", "Jepara, Jawa Tengah"),
            Pahlawan("Teuku Umar", "Meulaboh, Aceh"),
            Pahlawan("Agus Salim", "Padang Panjang, Sumatera Barat"),
        )
    }
}