package com.example.testexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import android.view.View
import android.view.ViewGroup
import com.example.testexercise.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
   private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = arguments?.getSerializable("key") as CarModel
        binding.tvName.text = model.name
        binding.tvYear.text = model.year
        Glide.with(binding.imgDetail)
            .load(model.image)
            .into(binding.imgDetail)
    }
}