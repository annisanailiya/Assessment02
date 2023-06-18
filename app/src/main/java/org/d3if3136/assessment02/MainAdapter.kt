package org.d3if3136.assessment02

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3136.assessment02.databinding.ListItemBinding
import org.d3if3136.assessment02.model.Pahlawan
import org.d3if3136.assessment02.network.PahlawanApi

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data = mutableListOf<Pahlawan>()

    fun updateData(newData: List<Pahlawan>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pahlawan: Pahlawan) = with(binding) {
            namaTextView.text = pahlawan.nama
            asalTextView.text = pahlawan.asal
            sejarahTextView.text = pahlawan.sejarah
            Glide.with(imageView.context)
                .load(PahlawanApi.getPahlawanUrl(pahlawan.imageResId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, pahlawan.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

}