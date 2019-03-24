package com.sasakisan.android_custom_view_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sasakisan.android_custom_view_sample.databinding.ActivityMenuBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    private val menuAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)

        binding.recyclerView.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

        val list = arrayListOf(
            MenuItem("Canvas View", View.OnClickListener {
                startActivity(Intent(this, CanvasViewActivity::class.java))
            })
        )
        menuAdapter.update(list)
    }
}
