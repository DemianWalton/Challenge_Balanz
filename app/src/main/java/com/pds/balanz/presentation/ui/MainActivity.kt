package com.pds.balanz.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pds.balanz.databinding.ActivityMainBinding
import com.pds.balanz.presentation.adapter.CryptoAdapter
import com.pds.balanz.presentation.crypto_list.CryptoListState
import com.pds.balanz.presentation.crypto_list.CryptoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CryptoListViewModel by viewModels()
    private var adapter: CryptoAdapter? = CryptoAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { event ->
                when (event) {
                    is CryptoListState.Success -> {
                        adapter!!.submitList(event.result)
                        binding.rvMain.adapter = adapter
                    }
                    is CryptoListState.Failure -> {
                        adapter!!.submitList(event.result)
                        binding.rvMain.adapter = adapter
                    }
                    is CryptoListState.Loading -> {
                    }
                    else -> Unit
                }
            }
        }
    }
}