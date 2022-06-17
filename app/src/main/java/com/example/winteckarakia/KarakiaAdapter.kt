package com.example.winteckarakia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class KarakiaAdapter(private var dataList: List<KarakiaData>, private val listener: OnItemClickListener) : RecyclerView.Adapter<KarakiaAdapter.ViewHolder>(){

    internal fun setDataList(dataList: List<KarakiaData>) {
        this.dataList = dataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_model,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.desc.text = data.desc
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount() = dataList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var image: ImageView = itemView.findViewById(R.id.row_image_view)
        var desc: TextView = itemView.findViewById(R.id.row_text_view)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}