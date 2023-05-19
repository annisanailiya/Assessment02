package org.d3if3136.assessment02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import org.d3if3136.assessment02.databinding.ActivityMainBinding
import org.d3if3136.assessment02.model.HasilInput

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lanjutButton.setOnClickListener { welcome() }
    }

    private fun welcome() {
        val nama = binding.namaInp.text.toString()
        if (TextUtils.isEmpty(nama)) {
            Toast.makeText(this, R.string.nama_invalid, Toast.LENGTH_LONG).show()
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