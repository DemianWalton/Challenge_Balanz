package com.pds.balanz.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.pds.balanz.domain.model.Crypto

data class CryptoDto(
    @SerializedName("askPrice")
    val askPrice: String,
    @SerializedName("askQty")
    val askQty: String,
    @SerializedName("bidPrice")
    val bidPrice: String,
    @SerializedName("bidQty")
    val bidQty: String,
    @SerializedName("closeTime")
    val closeTime: Long,
    @SerializedName("count")
    val count: Int,
    @SerializedName("firstId")
    val firstId: Int,
    @SerializedName("highPrice")
    val highPrice: String,
    @SerializedName("lastId")
    val lastId: Int,
    @SerializedName("lastPrice")
    val lastPrice: String,
    @SerializedName("lastQty")
    val lastQty: String,
    @SerializedName("lowPrice")
    val lowPrice: String,
    @SerializedName("openPrice")
    val openPrice: String,
    @SerializedName("openTime")
    val openTime: Long,
    @SerializedName("prevClosePrice")
    val prevClosePrice: String,
    @SerializedName("priceChange")
    val priceChange: String,
    @SerializedName("priceChangePercent")
    val priceChangePercent: String,
    @SerializedName("quoteVolume")
    val quoteVolume: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("volume")
    val volume: String,
    @SerializedName("weightedAvgPrice")
    val weightedAvgPrice: String
)

fun CryptoDto.toCrypto(): Crypto {
    return Crypto(
        askPrice = askPrice,
        askQty = askQty,
        bidPrice = bidPrice,
        bidQty = bidQty,
        closeTime = closeTime,
        count = count,
        firstId = firstId,
        highPrice = highPrice,
        lastId = lastId,
        lastPrice = lastPrice,
        lastQty = lastQty,
        lowPrice = lowPrice,
        openPrice = openPrice,
        openTime = openTime,
        prevClosePrice = prevClosePrice,
        priceChange = priceChange,
        priceChangePercent = priceChangePercent,
        quoteVolume = quoteVolume,
        symbol = symbol,
        volume = volume,
        weightedAvgPrice = weightedAvgPrice
    )
}