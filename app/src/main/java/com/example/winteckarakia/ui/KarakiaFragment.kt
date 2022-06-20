package com.example.winteckarakia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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

        val btn_click_english= view.findViewById(R.id.translate_button_english) as Button
        val btn_click_maori = view.findViewById(R.id.translate_button_maori) as Button
        val TextView = view.findViewById(R.id.text_view_karakia) as TextView
        val TextEnglish = view.findViewById(R.id.text_english) as TextView
        val TextMaori = view.findViewById(R.id.text_maori) as TextView
        btn_click_english.setOnClickListener {
            TextView.text = TextEnglish.text
        }
        btn_click_maori.setOnClickListener {
            TextView.text = TextMaori.text
        }


        binding.apply {
            karakia = args.details
            getVideoView.setVideoPath(args.details.karakiavideo)

        }
        getVideoView.start()
    }

}