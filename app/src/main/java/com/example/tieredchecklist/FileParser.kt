package com.example.tieredchecklist

import com.example.tieredchecklist.models.*

class FileParser {
    fun parse(text: String): MutableList<Tier> {
        val tiers = mutableListOf<Tier>()
        var currentTier: Tier? = null

        text.lines().forEach { raw ->
            val line = raw.trim()
            if (line.isBlank()) return@forEach

            if (line.startsWith("#")) {
                currentTier = Tier(line.removePrefix("#").trim())
                tiers.add(currentTier!!)
            } else {
                currentTier?.items?.add(ChecklistItem(text = line))
            }
        }

        return tiers
    }
}
