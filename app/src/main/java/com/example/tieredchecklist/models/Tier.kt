package com.example.tieredchecklist.models

data class Tier(
    val name: String,
    var expanded: Boolean = true,
    val items: MutableList<ChecklistItem> = mutableListOf()
)
