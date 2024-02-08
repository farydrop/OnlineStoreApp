package com.farydrop.onlinestoreapp.data.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return Gson().toJson(list)
    }
}

class InfoListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): List<Info> {
        val listType = object : TypeToken<List<Info>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Info>): String {
        return gson.toJson(list)
    }
}

class FeedbackConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): Feedback {
        return gson.fromJson(value, Feedback::class.java)
    }

    @TypeConverter
    fun fromFeedback(feedback: Feedback): String {
        return gson.toJson(feedback)
    }
}

class PriceConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String): Price {
        return gson.fromJson(value, Price::class.java)
    }

    @TypeConverter
    fun fromPrice(price: Price): String {
        return gson.toJson(price)
    }
}