package com.udacity.shoestore.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

class ShoeDetailsFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()
    private val args: ShoeDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        with(binding) {
            viewModel = this@ShoeDetailsFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            shoe = args.shoe
        }

        viewModel.navigateToListing.observe(viewLifecycleOwner) { navigate ->
            if (navigate != null && navigate) {
                findNavController().navigate(
                    ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListingFragment()
                )
                viewModel.doneNavigating()
            }
        }
        return binding.root
    }
}