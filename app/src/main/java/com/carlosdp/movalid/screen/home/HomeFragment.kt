package com.carlosdp.movalid.screen.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.carlosdp.movalid.R
import com.carlosdp.movalid.databinding.DetailFragmentBinding
import com.carlosdp.movalid.databinding.HomeFragmentBinding
import com.carlosdp.movalid.screen.detail.DetailViewModel

class HomeFragment  : Fragment() {
    private lateinit var viewModel: HomeViewModel
    //
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )

        // Get the VIewModel
        Log.i("GameFragment" ,"Called ViewModelProviders.of!")
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding.homeViewModel = viewModel

        binding.imageSearch.setOnClickListener {
            //TODO:  Revisar como hizo el Directions
            findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToSearchFragment())
        }
        return binding.root
    }

}
