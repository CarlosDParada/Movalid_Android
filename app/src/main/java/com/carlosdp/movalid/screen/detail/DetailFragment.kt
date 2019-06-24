package com.carlosdp.movalid.screen.detail


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.carlosdp.movalid.R
import com.carlosdp.movalid.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
//
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_fragment,
            container,
            false
        )

        // Get the VIewModel
        Log.i("GameFragment" ,"Called ViewModelProviders.of!")
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

        binding.detailViewModel = viewModel

        return binding.root

    }

}
