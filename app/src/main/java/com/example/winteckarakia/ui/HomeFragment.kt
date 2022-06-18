package com.example.winteckarakia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.winteckarakia.R
import com.example.winteckarakia.data.KarakiaMenuAdapter
import com.example.winteckarakia.data.KarakiaMenuData
import com.example.winteckarakia.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home), KarakiaMenuAdapter.OnItemClickListener {

    private lateinit var karakiaMenuAdapter: KarakiaMenuAdapter
    private lateinit var recyclerView: RecyclerView
    private var dataList = mutableListOf<KarakiaMenuData>()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)
        recyclerView = requireView().findViewById(R.id.recyclerView)
        karakiaMenuAdapter = KarakiaMenuAdapter(mutableListOf(), this)

        binding.apply {
            recyclerView.adapter = karakiaMenuAdapter
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerView.setHasFixedSize(true)
        }

        dataList.add(KarakiaMenuData(R.drawable.karakia1, "Karakia Timatanga - Tahi(Opening One)"))
        dataList.add(KarakiaMenuData(R.drawable.karakia2, "Karakia Timatanga - Tahi(Opening Rua)"))
        dataList.add(KarakiaMenuData(R.drawable.karakia3, "Karakia Ki Te Kai (Blessing for food)"))
        dataList.add(KarakiaMenuData(R.drawable.karakia4, "Karakia Whakamutunga Tahi (Closing One)"))
        dataList.add(KarakiaMenuData(R.drawable.karakia5, "Karakia Whakamutunga Rua (Closing Two)"))
        dataList.add(KarakiaMenuData(R.drawable.karakia6, "Hītori - History"))
        karakiaMenuAdapter.setDataList(dataList)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: KarakiaMenuData = dataList[position]
        clickedItem.desc = "Clicked"
        karakiaMenuAdapter.notifyItemChanged(position)
    }

}