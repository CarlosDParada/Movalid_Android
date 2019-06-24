package com.carlosdp.movalid.screen.search


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.carlosdp.movalid.R
import com.carlosdp.movalid.databinding.SearchFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SearchFragment : Fragment() {

    // Add ViewModel
    private lateinit var viewModel: SearchViewModel


    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.search_fragment,
            container,
            false
        )

        // Get the VIewModel
        Log.i("GameFragment", "Called ViewModelProviders.of!")
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        binding.searchViewModel = viewModel
        return binding.root

    }

}