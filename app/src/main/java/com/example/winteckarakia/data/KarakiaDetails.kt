package com.example.winteckarakia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KarakiaDetails(
    var karakiaimage: Int,
    var karakiavideo: String,
    var karakia: String,
    var karakiaenglishtext: String,
    var karakiaengmaoritext: String,
    var historytext: String
) : Parcelable {
    var textlang = karakiaenglishtext
}