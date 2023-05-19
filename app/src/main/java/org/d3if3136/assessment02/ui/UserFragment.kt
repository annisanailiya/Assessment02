package org.d3if3136.assessment02.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.databinding.FragmentUserBinding
import org.d3if3136.assessment02.model.HasilInput

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentUserBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lanjutButton.setOnClickListener { welcome() }
        binding.masukButton.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_userFragment_to_listFragment
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_userFragment_to_aboutFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun welcome() {
        val nama = binding.namaInp.text.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(context, R.string.nama_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val lanjut = nama
        binding.namaTextView.text = getString(R.string.nama_x, lanjut)

        binding.masukButton.visibility = View.VISIBLE
    }

//    private fun showResult(result: HasilInput) {
//        binding.namaTextView.text = getString(R.string.nama_x,result.lanjut)
//    }
}