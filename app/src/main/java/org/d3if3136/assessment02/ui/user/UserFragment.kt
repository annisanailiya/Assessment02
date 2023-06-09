package org.d3if3136.assessment02.ui.user

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.databinding.FragmentUserBinding
import org.d3if3136.assessment02.db.UserDb
import org.d3if3136.assessment02.model.HasilInput

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    private val viewModel: UserViewModel by lazy {
        val db = UserDb.getInstance(requireContext())
        val factory = UserViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[UserViewModel::class.java]
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
        binding.shareButton.setOnClickListener { shareData() }
    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template,
            binding.namaTextView.text
        )
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_userFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_userFragment_to_aboutFragment)
                return true
            }
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
        binding.buttonGroup.visibility = View.VISIBLE
        viewModel.welcome(
            nama.toString()
        )
    }

    private fun showResult(result: HasilInput) {
        if (result == null) return

    }
}