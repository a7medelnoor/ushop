package com.a7medelnoor.ushop.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.adapters.SliderAdapter
import com.a7medelnoor.ushop.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val imageList: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.imageViewAllCategories.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_allCategoriesFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageSlider = binding.slider
        imageList.add("https://ushop.ae/media/upload/photos/default.png")
        imageList.add("https://ushop.ae/media/upload/photos/2021/07/SEEsbeP6Wzz9uA96o7Ks7B3W1nQMiOUfycbbyH65rmQktOubw6_06_a8d2c20e6212c8545c0a9f5db9a06a6e_image.png")
        imageList.add("https://media.istockphoto.com/photos/child-hands-formig-heart-shape-picture-id951945718?k=6&m=951945718&s=612x612&w=0&h=ih-N7RytxrTfhDyvyTQCA5q5xKoJToKSYgdsJ_mHrv0=")
        setImageSlider(imageList, imageSlider)
    }

    private fun setImageSlider(imageList: ArrayList<String>, imageSlider: SliderView) {
        val adapter = SliderAdapter()
        adapter.renewItem(imageList)
        imageSlider.setSliderAdapter(adapter)
        imageSlider.isAutoCycle = true
        imageSlider.stopAutoCycle()

    }

}