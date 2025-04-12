package com.example.myapplication

data class SpendRequest(
    val name: String,
    val event: String,
    val amount: String,
    val dateRange: String,
    val createdDate: String,
    val type: String
)

val dummySpendRequests = listOf(
    SpendRequest("Melbourne conference", "3,000.00 NZD", "Used since 2023", "10 Apr 2024 - 23 Apr 2024", "10 Feb 2024", "New Spend Request"),
    SpendRequest("Client Event Q1 2024", "5,000.00 NZD", "Used since 2022", "01 Jan 2024 - 30 Jan 2024", "12 Mar 2023", "Expense Claim")
)