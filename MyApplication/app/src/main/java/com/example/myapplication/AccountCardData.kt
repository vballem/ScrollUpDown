package com.example.myapplication

data class AccountCardData(val title: String, val subtitle: String, val amount: String)

val dummyAccountCards = listOf(
    AccountCardData("My Company card", "Available (NZD)", "1,500,000.00"),
    AccountCardData("Trip to Salt Lake City", "Virtual card", "1,234.00"),
    AccountCardData("Burnett, Aaron", "3 Corporate cards", "—")
)