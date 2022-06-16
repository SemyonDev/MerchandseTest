package com.tapmobile.merchandsetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tapmobile.merchandsetest.R
import com.tapmobile.merchandsetest.databinding.ActivityMainBinding
import com.tapmobile.merchandsetest.ui.adapters.MerchandiseRVAdapter
import com.tapmobile.myapplication.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    private var merchandiseRVAdapter = MerchandiseRVAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityMainLoading.visibility = View.VISIBLE
        viewModel.merchandiseList.observe(this, androidx.lifecycle.Observer {
            merchandiseRVAdapter.addItems(it.merchandises)
            binding.activityMainRv.apply {
                binding.activityMainLoading.visibility = View.GONE
                adapter = merchandiseRVAdapter
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }
        })
    }
}