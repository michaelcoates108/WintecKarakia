package com.example.winteckarakia.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.winteckarakia.MainActivity
import com.example.winteckarakia.R
import com.example.winteckarakia.databinding.FragmentKarakiaBinding

class KarakiaFragment : Fragment(R.layout.fragment_karakia) {
    private val args by navArgs<KarakiaFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_karakia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentKarakiaBinding.bind(view)

        (requireActivity() as MainActivity).title = binding.karakia?.karakia

        var media_controller = MediaController(requireContext())

        binding.translateButtonEnglish.setOnClickListener {
            binding.textViewKarakia.text = binding.karakia!!.karakiaenglishtext
        }
        binding.translateButtonMaori.setOnClickListener {
            binding.textViewKarakia.text = binding.karakia!!.karakiaengmaoritext
        }

        media_controller.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(media_controller)

        binding.karakiaVideoButton.setOnClickListener {
            binding.videoView.start()
            binding.karakiaVideoButton.visibility = View.GONE
        }


        binding.apply {
            karakia = args.details
            videoView.setVideoPath(args.details.karakiavideo)
        }

        binding.videoView.setOnCompletionListener {
            binding.karakiaVideoButton.visibility = View.VISIBLE
        }

    }

}