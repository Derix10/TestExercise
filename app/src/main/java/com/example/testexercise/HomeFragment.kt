package com.example.testexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testexercise.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeAdapter(this::onClick)
        adapter.addElement(CarModel("https://freepngimg.com/save/36581-mercedes-benz-picture/2196x1302", "Mers", "2020"))
        adapter.addElement(CarModel("https://freepngimg.com/save/36581-mercedes-benz-picture/2196x1302", "Mers", "2020"))
        adapter.addElement(CarModel("https://freepngimg.com/save/36581-mercedes-benz-picture/2196x1302", "Mers", "2020"))
        adapter.addElement(CarModel("https://freepngimg.com/save/36581-mercedes-benz-picture/2196x1302", "Mers", "2020"))
        adapter.addElement(CarModel("https://freepngimg.com/save/36581-mercedes-benz-picture/2196x1302", "Mers", "2020"))
        adapter.addElement(CarModel("https://freepngimg.com/save/36581-mercedes-benz-picture/2196x1302", "Mers", "2020"))
        binding.rvHome.adapter = adapter
    }
    fun onClick(carModel: CarModel){
        val bundle = Bundle()
        bundle.putSerializable("key", carModel)
        findNavController().navigate(R.id.detailFragment)
    }
}