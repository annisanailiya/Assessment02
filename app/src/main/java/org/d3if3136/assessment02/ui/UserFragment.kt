package org.d3if3136.assessment02.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lanjutButton.setOnClickListener { welcome() }
    }

    private fun welcome() {
        val nama = binding.namaInp.text.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(context, R.string.nama_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val lanjut = nama
        binding.namaTextView.text = getString(R.string.nama_x, lanjut)
    }

    private fun showResult(result: HasilInput) {
        if (result == null) return

        binding.namaTextView.text = getString(R.string.nama_x,result.lanjut)
    }
}