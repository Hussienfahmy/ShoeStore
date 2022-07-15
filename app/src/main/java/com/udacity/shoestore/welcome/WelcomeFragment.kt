package com.udacity.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.welcome.WelcomeViewModel

class WelcomeFragment : Fragment() {

    private val viewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        with(binding) {
            viewModel = this@WelcomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.navigateToInstructionsScreenEvent.observe(viewLifecycleOwner) { navigate ->
            if (navigate != null && navigate) {
                findNavController().navigate(
                    WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
                )

                viewModel.doneNavigating()
            }
        }

        return binding.root
    }

}