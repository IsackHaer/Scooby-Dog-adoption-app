package com.example.scooby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.scooby.adapter.DogAdapter
import com.example.scooby.data.DataSource
import com.example.scooby.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val datasource = DataSource(this)
        val dogsList = datasource.getDogs()
        val snapHelper = PagerSnapHelper()

        binding.RecyclerView.adapter = DogAdapter(this, dogsList)
        binding.RecyclerView.setHasFixedSize(true)
        snapHelper.attachToRecyclerView(binding.RecyclerView)

    }
}