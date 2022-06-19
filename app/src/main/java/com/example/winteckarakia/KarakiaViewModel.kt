package com.example.winteckarakia

import androidx.lifecycle.ViewModel
import com.example.winteckarakia.data.KarakiaDetails

data class KarakiaViewModel(
    var menuimage: Int,
    var menudesc: String,
    var karadetails: KarakiaDetails

) : ViewModel()
