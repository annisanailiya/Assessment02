package org.d3if3136.assessment02.ui

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import org.d3if3136.assessment02.MainAdapter
import org.d3if3136.assessment02.model.Pahlawan
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.data.SettingDataStore
import org.d3if3136.assessment02.data.dataStore
import org.d3if3136.assessment02.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private var isLinearLayoutManager = true
    private lateinit var layoutDataStore: SettingDataStore

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
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getData(): List<Pahlawan> {
        return listOf(
            Pahlawan("Soekarno ", "Surabaya, Jawa Timur", "Soekarno adalah Proklamator Kemerdekaan Indone..."),
            Pahlawan("Mohammad Hatta", "Bukittinggi, Sumatera Barat", "Muhammad Hatta, atau Dr. Mohammad Hatta, ad..."),
            Pahlawan("Sultan Hasanuddin", "Gowa, Sulawesi Selatan", "Sultan Hasanuddin adalah pahlawan nasional ..."),
            Pahlawan("Cut Nyak Dien", "Aceh, Sumatera Utara", "Cut Nyak Dien adalah pahlawan nasional Indones..."),
            Pahlawan("Diponegoro", "Yogyakarta, Jawa Tengah", "Diponegoro adalah pahlawan nasional Indones..."),
            Pahlawan("Tan Malaka", "Pandan Gadang, Sumatera Barat", "Tan Malaka adalah seorang tokoh revolusione..."),
            Pahlawan("Ki Hajar Dewantara", "Yogyakarta, Jawa Tengah", "Ki Hajar Dewantara adalah seorang pendidik ..."),
            Pahlawan("RA. Kartini", "Jepara, Jawa Tengah", "R.A. Kartini adalah seorang pahlawan nasion..."),
            Pahlawan("Teuku Umar", "Meulaboh, Aceh", "Teuku Umar adalah pahlawan nasional Indones..."),
            Pahlawan("Agus Salim", "Padang Panjang, Sumatera Barat", "Agus Salim adalah seorang tokoh nasional In..."),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutDataStore = SettingDataStore(requireContext().dataStore)
        layoutDataStore.preferenceFlow.asLiveData()
            .observe(viewLifecycleOwner) { value ->
                isLinearLayoutManager = value
                chooseLayout()
                activity?.invalidateOptionsMenu()
            }
//        viewModel.getData().observe(viewLifecycleOwner) {
//            myAdapter.updateData(it)
//        }
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            binding.recyclerView.layoutManager =
                LinearLayoutManager(this.requireContext())
        } else {
            binding.recyclerView.layoutManager =
                GridLayoutManager(this.requireContext(), 2)
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null) return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_grid_view_24
                )
            else ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_baseline_view_list_24
            )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager

                lifecycleScope.launch {
                    layoutDataStore.saveLayoutToPreferencesStore(
                        isLinearLayoutManager, requireContext()
                    )
                }

                // Sets layout and icon
                chooseLayout()
                setIcon(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

