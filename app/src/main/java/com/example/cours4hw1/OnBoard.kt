package com.example.cours4hw1

import java.io.Serializable

data class OnBoard(
    var animation : Int? = null,
    var title: String? = null,
    var description : String? = null,

) : Serializable