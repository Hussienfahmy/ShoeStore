package com.udacity.shoestore

import android.view.Gravity
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseMethod
import com.udacity.shoestore.databinding.LayoutShoeItemBinding
import com.udacity.shoestore.listing.ShoeViewModel
import com.udacity.shoestore.models.Shoe

/**
 * binds a list of show to the linear layout
 * inflate the children of the show item or inflate a sign to add a new shoe
 */
@BindingAdapter("list", "viewModel", requireAll = true)
fun LinearLayout.bindList(list: List<Shoe>, viewModel: ShoeViewModel) {
    // remove all old views
    this.removeAllViews()

    if (list.isNotEmpty()) {
        // add the children
        list.forEach { shoe ->
            // inflate the item binding
            val itemBinding: LayoutShoeItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.layout_shoe_item, this, false
            )
            itemBinding.shoe = shoe
            itemBinding.viewModel = viewModel

            addView(itemBinding.root)
        }
    }
}
