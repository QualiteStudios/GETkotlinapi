package com.qualitestudios.qualitehttp.data.remote

data class DataObject (


    val userid:Int,
    val id:Int,
    val title:String,
    val body:String
        )

data class NationData(

val name:String,
val country:Details
)

data class Details(


    val country_id:String,
    val probability:Int
)
