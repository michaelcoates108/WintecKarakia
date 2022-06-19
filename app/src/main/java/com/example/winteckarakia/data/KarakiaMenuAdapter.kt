package com.example.winteckarakia.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.winteckarakia.KarakiaViewModel
import com.example.winteckarakia.R
import com.example.winteckarakia.databinding.RowModelBinding


class KarakiaMenuAdapter(
    val menuViewModel: List<KarakiaViewModel>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<KarakiaMenuAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowModelBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_model,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuViewModel[position])

    }

    override fun getItemCount() = menuViewModel.size

    inner class ViewHolder(private var binding: RowModelBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        fun bind(newBinding: KarakiaViewModel){
            binding.data = newBinding

            itemView.setOnClickListener(this)

        }


        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                if (position != null) {
                    listener.onItemClick(binding.data!!)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(data: KarakiaViewModel)
    }
}