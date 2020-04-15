package com.mywork.sample.reactivedemo

data class DateResponse (
        val dates: Dates
)

data class Dates(
        val next: String,
        val last: String
)