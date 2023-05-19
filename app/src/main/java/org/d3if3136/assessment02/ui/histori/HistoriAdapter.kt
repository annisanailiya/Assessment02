package org.d3if3136.assessment02.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3136.assessment02.R
import org.d3if3136.assessment02.databinding.ItemHistoriBinding
import org.d3if3136.assessment02.db.UserEntity
import org.d3if3136.assessment02.model.welcome
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<UserEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<UserEntity>() {
                override fun areItemsTheSame(
                    oldData: UserEntity, newData: UserEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: UserEntity, newData: UserEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: UserEntity) = with(binding) {
            val hasilInput = item.welcome()

            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            usernameHistori.text = root.context.getString(
                R.string.nama_x,
                hasilInput.lanjut
            )
        }
    }
}