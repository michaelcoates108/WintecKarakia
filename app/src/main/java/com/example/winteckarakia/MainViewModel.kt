package com.example.winteckarakia

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textOptions = karakiaTextList()
    val imageOptions = karakiaImageList()

    private fun karakiaTextList() : List<String> {
        val karakiaText = mutableListOf<String>()
        karakiaText.add("Karakia Timatanga - Tahi(Opening One)")
        karakiaText.add("Karakia Timatanga - Rua(Opening Two)")
        karakiaText.add("Karakia Ki Te Kai (Blessing for food)")
        karakiaText.add("Karakia Whakamutunga Tahi (Closing One)")
        karakiaText.add("Karakia Whakamutunga Rua (Closing Two)")
        karakiaText.add("Hītori - History")

        return karakiaText

    }

    private fun karakiaImageList() : List<Int> {
        val karakiaImage = mutableListOf<Int>()
        karakiaImage.add(R.drawable.karakia1)
        karakiaImage.add(R.drawable.karakia2)
        karakiaImage.add(R.drawable.karakia3)
        karakiaImage.add(R.drawable.karakia4)
        karakiaImage.add(R.drawable.karakia5)
        karakiaImage.add(R.drawable.karakia6)

        return karakiaImage

    }


}