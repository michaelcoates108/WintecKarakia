package com.example.winteckarakia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KarakiaDetails(
    var karakiaimage: Int,
    var karakiavideo: String,
    var karakiatext: String,
    var historytext: String
) : Parcelable