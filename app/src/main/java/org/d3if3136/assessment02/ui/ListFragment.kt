package org.d3if3136.assessment02.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3136.assessment02.MainAdapter
import org.d3if3136.assessment02.Pahlawan
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = MainAdapter(getData())
            setHasFixedSize(true)
        }

        return binding.root
    }

    private fun getData(): List<Pahlawan> {
        return listOf(
            Pahlawan("Soekarno ", "Surabaya, Jawa Timur", R.drawable.ic_launcher_background),
            Pahlawan("Mohammad Hatta", "Bukittinggi, Sumatera Barat", R.drawable.ic_launcher_background),
            Pahlawan("Sultan Hasanuddin", "Gowa, Sulawesi Selatan", R.drawable.ic_launcher_background),
            Pahlawan("Cut Nyak Dien", "Aceh, Sumatera Utara", R.drawable.ic_launcher_background),
            Pahlawan("Diponegoro", "Yogyakarta, Jawa Tengah", R.drawable.ic_launcher_background),
            Pahlawan("Tan Malaka", "Pandan Gadang, Sumatera Barat", R.drawable.ic_launcher_background),
            Pahlawan("Ki Hajar Dewantara", "Yogyakarta, Jawa Tengah", R.drawable.ic_launcher_background),
            Pahlawan("RA. Kartini", "Jepara, Jawa Tengah", R.drawable.ic_launcher_background),
            Pahlawan("Teuku Umar", "Meulaboh, Aceh", R.drawable.ic_launcher_background),
            Pahlawan("Agus Salim", "Padang Panjang, Sumatera Barat", R.drawable.ic_launcher_background),
        )
    }
}

