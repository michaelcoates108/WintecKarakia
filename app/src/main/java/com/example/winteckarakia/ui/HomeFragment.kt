package com.example.winteckarakia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.winteckarakia.data.KarakiaDetails
import com.example.winteckarakia.KarakiaViewModel
import com.example.winteckarakia.R
import com.example.winteckarakia.data.KarakiaDataJson
import com.example.winteckarakia.data.KarakiaMenuAdapter
import com.example.winteckarakia.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class HomeFragment : Fragment(R.layout.fragment_home), KarakiaMenuAdapter.OnItemClickListener {

    private lateinit var karakiaMenuAdapter: KarakiaMenuAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val contents = readFile("Karakia.json")
        val dataList =
            Gson().fromJson<Array<KarakiaDataJson>>(contents, Array<KarakiaDataJson>::class.java)
                .map {
                    var resourceID = requireContext().resources.getIdentifier(
                        it.image,
                        "drawable",
                        requireContext().packageName
                    )
                    var resourceIDVideo = requireContext().resources.getIdentifier(
                        it.video,
                        "raw",
                        requireContext().packageName
                    )
                    KarakiaViewModel(
                        resourceID,
                        it.karakia,
                        KarakiaDetails(
                            resourceID,
                            getFilePath(resourceIDVideo),
                            it.karakia,
                            it.englishWords,
                            it.maoriWords,
                            ""
                        )
                    )
                }.toMutableList()

        _binding = FragmentHomeBinding.bind(view)

        karakiaMenuAdapter = KarakiaMenuAdapter(dataList, this)

        binding.apply {
            recyclerView.adapter = karakiaMenuAdapter
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            recyclerView.setHasFixedSize(true)
        }

    }

    fun readFile(fileName: String): String {
        try {
            val inputStream: InputStream = requireContext().assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            return String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getFilePath(i: Int): String {
        if (i == 0) {
            return ""
        }
        return "android.resource://" + requireContext().packageName + "/" + i
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(data: KarakiaViewModel) {
        if (data.karadetails.karakiavideo.isNullOrEmpty()) {
            val action =
                HomeFragmentDirections.actionHomeFragmentToHistoryFragment(data.karadetails)
            findNavController().navigate(action)
        } else {
            val action =
                HomeFragmentDirections.actionHomeFragmentToKarakiaFragment(data.karadetails, data.karadetails.karakia)
            findNavController().navigate(action)
        }

    }


}