package com.example.winteckarakia

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

class KarakiaAdapter(
    private val mContext: Context,
    data: MutableList<HashMap<String, String>>,
    @LayoutRes
    res: Int,
    from: Array<String>,
@IdRes
to: IntArray
) : SimpleAdapter(mContext, data, res, from, to) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = super.getView(position, convertView, parent)
        val imageView = view.findViewById<ImageView>(R.id.home_image_view)
        val karakiaText = view.findViewById<TextView>(R.id.home_text_view)

        return view
    }
}