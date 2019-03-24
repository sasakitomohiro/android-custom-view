package com.sasakisan.android_custom_view_sample

import android.view.View
import com.sasakisan.android_custom_view_sample.databinding.ItemMenuBinding
import com.xwray.groupie.databinding.BindableItem

class MenuItem(private val title: String, private val onClickListener: View.OnClickListener?) : BindableItem<ItemMenuBinding>() {
    override fun getLayout(): Int = R.layout.item_menu

    override fun bind(viewBinding: ItemMenuBinding, position: Int) {
        viewBinding.title.text = title
        viewBinding.root.setOnClickListener(onClickListener)
    }
}