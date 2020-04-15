package com.mywork.sample.reactivedemo

data class DrugResponse(
        val drugs: List<Drugs>
)

data class Drugs(
        val name: String,
        val strength: String
)