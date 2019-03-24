package com.sasakisan.android_custom_view_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sasakisan.android_custom_view_sample.databinding.ActivityCanvasViewBinding

class CanvasViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCanvasViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_canvas_view)

        binding.back.setOnClickListener {
            finish()
        }
        binding.clear.setOnClickListener {
            binding.canvas.deleteAll()
        }
    }
}
