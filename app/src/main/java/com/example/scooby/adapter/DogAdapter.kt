package com.example.scooby.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.scooby.R
import com.example.scooby.data.model.Dog

class DogAdapter(
    private val context: Context,
    private val dataset: List<Dog>
) : RecyclerView.Adapter<DogAdapter.itemViewHolder>() {

    class itemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val dogName = view.findViewById<TextView>(R.id.dogName_tv)
        val dogAge = view.findViewById<TextView>(R.id.dogAge_tv)
        val dogWeight = view.findViewById<TextView>(R.id.dogWeight_tv)
        val dogImage = view.findViewById<ImageView>(R.id.dogImage_iv)

        val adoptButton = view.findViewById<Button>(R.id.adopt_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_item, parent, false)

        return itemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val dog = dataset[position]

        holder.dogImage.setImageResource(dog.image)

        holder.dogName.text = dog.name
        holder.dogAge.text = "${dog.age} months"
        holder.dogWeight.text = "${dog.weight}kg"

        holder.adoptButton.setOnClickListener {
            Toast.makeText(context, "${dog.name} has been adopted by you", Toast.LENGTH_SHORT)
                .show()
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}