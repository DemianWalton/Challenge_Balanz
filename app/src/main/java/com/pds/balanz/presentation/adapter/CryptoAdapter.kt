package com.pds.balanz.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pds.balanz.R
import com.pds.balanz.domain.model.Crypto


class CryptoAdapter(
) : ListAdapter<Crypto, CryptoViewHolder>(CryptoDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)
        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val cryptoItem = getItem(position)
        holder.bind(cryptoItem)
    }

    object CryptoDiffCallback : DiffUtil.ItemCallback<Crypto>() {
        override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
            return true
        }
    }
}

class CryptoViewHolder(
    view: View,
) : RecyclerView.ViewHolder(view) {

    private var symbol = view.findViewById<TextView>(R.id.tv_crypto_symbol)

    fun bind(crypto: Crypto) {
        symbol.text = crypto.symbol
    }
}
