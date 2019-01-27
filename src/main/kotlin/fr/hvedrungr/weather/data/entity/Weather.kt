package fr.hvedrungr.weather.data.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import fr.hvedrungr.weather.client.WeatherDeserializer

@JsonDeserialize(using = WeatherDeserializer::class)
data class Weather(
        var name: String,
        var desc: String,
        var iconCode: String,
        var city: City,
        var humidity: Humidity,
        var pressure: Pressure,
        var temperature: Temperature,
        var wind: Wind,
        var clouds: Clouds
)