package com.mobven.yummy.presentation.shop

data class Restaurant(
    val name: String = "Grandma's shop",
    val bannerImage: String = "https://dil-rjcorp.com/wp-content/uploads/2021/05/banner55.png",
    val iconImage: String = "https://cdn.iconscout.com/icon/free/png-256/free-kfc-2-226243.png",
    val isFavourite: Boolean = false,
    val address: String = "NYC, Broadway ave 79",
    val distance: String = "",
    val votes: String = "(1.2K)",
    val rate: String = "4.8",
    val totalOrders: String = "99+ orders",
)