package com.example.testexercise

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.testexercise.databinding.ItemRecyclerBinding

class HomeAdapter(val onClick: (carModel: CarModel)-> Unit): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    val list : ArrayList<CarModel> = arrayListOf()

    fun addElement(carModel: CarModel) {
        list.add(carModel)
        notifyDataSetChanged()
    }

    class HomeViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(carModel: CarModel) {
            Glide.with(binding.imgHomeItem)
                .load(carModel.image)
                .into(binding.imgHomeItem)

            binding.tvNameItem.text = carModel.name
            binding.tvYearItem.text = carModel.year
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener{
            onClick(list[position])
        }
    }
}