package com.example.scooby.data

import android.content.Context
import com.example.scooby.R
import com.example.scooby.data.model.Dog

data class DataSource(private val context: Context) {

    fun getDogs(): List<Dog> {
        return listOf(
            Dog("Poochie", 15, 2.2, R.drawable.dog1),
            Dog("Fight",5, 1.3, R.drawable.dog2),
            Dog("Spooky",12,1.1,R.drawable.dog3),
            Dog("Tuffy",24,0.5,R.drawable.dog4)
        )
    }
}