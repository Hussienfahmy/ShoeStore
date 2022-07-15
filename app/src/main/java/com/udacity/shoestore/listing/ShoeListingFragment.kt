package com.udacity.shoestore.listing

import android.os.Bundle
import android.view.*
import androidx.core.app.ActivityCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import timber.log.Timber

class ShoeListingFragment : Fragment(), MenuProvider {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeListingBinding.inflate(inflater, container, false)
        with(binding) {
            viewModel = this@ShoeListingFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.navigateToDetailsEvent.observe(viewLifecycleOwner) { shoe ->
            if (shoe != null) {
                findNavController().navigate(
                    ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailsFragment(
                        shoe
                    )
                )
                viewModel.doneNavigating()
            }
        }

        (requireActivity() as MenuHost).addMenuProvider(
            this,
            viewLifecycleOwner,
            Lifecycle.State.CREATED
        )

        return binding.root
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shoe_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.log_out) {
            findNavController().navigate(
                ShoeListingFragmentDirections.actionShoeListingFragmentToLoginFragment()
            )
        }

        return true
    }
}