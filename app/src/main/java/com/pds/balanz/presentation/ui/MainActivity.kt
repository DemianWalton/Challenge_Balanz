package com.pds.balanz.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.pds.balanz.R
import com.pds.balanz.databinding.ActivityMainBinding
import com.pds.balanz.general.DataEvent
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

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { event ->
                when (event) {
                    is CryptoListState.Success -> {
                        adapter!!.submitList(event.result)
                    }
                    is CryptoListState.Failure -> {
                        adapter!!.submitList(event.result)
                    }
                    is CryptoListState.Loading -> {
                    }
                    else -> Unit
                }
            }
        }
    }
}