package com.example.winteckarakia.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.winteckarakia.R


class KarakiaMenuAdapter(private var menuDataList: List<KarakiaMenuData>, private val listener: OnItemClickListener) : RecyclerView.Adapter<KarakiaMenuAdapter.ViewHolder>(){

    internal fun setDataList(menuDataList: List<KarakiaMenuData>) {
        this.menuDataList = menuDataList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_model,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = menuDataList[position]
        holder.desc.text = data.desc
        holder.image.setImageResource(data.image)
    }

    override fun getItemCount() = menuDataList.size

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