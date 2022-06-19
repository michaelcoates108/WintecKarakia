package com.example.winteckarakia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.winteckarakia.R
import com.example.winteckarakia.databinding.FragmentKarakiaBinding

class KarakiaFragment: Fragment(R.layout.fragment_karakia) {
    private val args by navArgs<KarakiaFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_karakia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentKarakiaBinding.bind(view)
        val getVideoView = view.findViewById<VideoView>(R.id.video_view)

        binding.apply {
            karakia = args.details
            getVideoView.setVideoPath(args.details.karakiavideo)

        }

        getVideoView.start()
    }

}