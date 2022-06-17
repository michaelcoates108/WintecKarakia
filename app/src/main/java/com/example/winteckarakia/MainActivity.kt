package com.example.winteckarakia


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(R.layout.activity_main), KarakiaAdapter.OnItemClickListener {

    private var dataList = mutableListOf<KarakiaData>()
    private lateinit var karakiaAdapter: KarakiaAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        karakiaAdapter = KarakiaAdapter(mutableListOf(), this)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = karakiaAdapter

        dataList.add(KarakiaData(R.drawable.karakia1, "Karakia Timatanga - Tahi(Opening One)"))
        dataList.add(KarakiaData(R.drawable.karakia2, "Karakia Timatanga - Tahi(Opening Rua)"))
        dataList.add(KarakiaData(R.drawable.karakia3, "Karakia Ki Te Kai (Blessing for food)"))
        dataList.add(KarakiaData(R.drawable.karakia4, "Karakia Whakamutunga Tahi (Closing One)"))
        dataList.add(KarakiaData(R.drawable.karakia5, "Karakia Whakamutunga Rua (Closing Two)"))
        dataList.add(KarakiaData(R.drawable.karakia6, "Hītori - History"))
        karakiaAdapter.setDataList(dataList)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem:KarakiaData = dataList[position]
        clickedItem.desc = "Clicked"
        karakiaAdapter.notifyItemChanged(position)
    }
}