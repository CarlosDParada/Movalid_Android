package com.carlosdp.movalid.screen.home


import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.carlosdp.movalid.R
import com.carlosdp.movalid.databinding.DetailFragmentBinding
import com.carlosdp.movalid.databinding.HomeFragmentBinding

import com.carlosdp.movalid.databinding.GridViewItemBinding
import com.carlosdp.movalid.screen.detail.DetailViewModel
import com.carlosdp.movalid.screen.home.PhotoGridAdapter

class HomeFragment  : Fragment() {

//    private lateinit var viewModel: HomeViewModel
//    private lateinit var binding: HomeFragmentBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
//        binding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.home_fragment,
//            container,
//            false
//        )
        val binding = HomeFragmentBinding.inflate(inflater)
//       var binding = GridViewItemBinding.inflate(inflater)


        binding.homeViewModel = viewModel

        val adapter = HomeFilmAdapter()
        binding.sleepList.adapter = adapter
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Do some stuff
            binding.sleepList.layoutManager = GridLayoutManager(context, 4)
        }else{
            binding.sleepList.layoutManager = GridLayoutManager(context, 2)
        }

        viewModel.properties.observe(viewLifecycleOwner , Observer {
            it?.let {
                adapter.data = it
            }
        })
        // Get the VIewModel
        binding.setLifecycleOwner(this)
//        binding.photosGrid.adapter = PhotoGridAdapter()

        binding.imageSearch.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToSearchFragment())
        }

        binding.buttonPopular.setOnClickListener {
            viewModel.getMoviePopular()
        }
        binding.buttonTopRated.setOnClickListener {
            viewModel.getMovieTopRated()
        }
        binding.buttonUpComing.setOnClickListener {
            viewModel.getMovieUpComing()
        }

        return binding.root
    }

}
