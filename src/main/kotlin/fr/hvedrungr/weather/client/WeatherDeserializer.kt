package fr.hvedrungr.weather.client

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import fr.hvedrungr.weather.data.entity.*
import org.springframework.stereotype.Component
import java.sql.Date
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Component
class WeatherDeserializer : StdDeserializer<Weather>(Weather::class.java) {
    override fun deserialize(jp: JsonParser?, ctx: DeserializationContext?): Weather {
        var node = jp!!.codec.readTree<JsonNode>(jp)

        var humidity = Humidity(
                value = node["main"]["humidity"].asDouble()
        )
        var pressure = Pressure(
                value = node["main"]["pressure"].asDouble()
        )
        var temperature = Temperature(
                value = node["main"]["temp"].asDouble(),
                min = node["main"]["temp_min"].asDouble(),
                max = node["main"]["temp_max"].asDouble()
        )
        var wind = Wind(
                speed = node["wind"]["speed"].asDouble(),
                degree = node["wind"]["deg"].asDouble()
        )
        var clouds = Clouds(
                cloudiness = node["clouds"]["all"].asDouble()
        )
        var sun = Sun(
                sunrise = LocalDateTime.ofInstant(Instant.ofEpochMilli(node["sys"]["sunrise"].asLong() * 1000), TimeZone.getDefault().toZoneId()),
                sunset = LocalDateTime.ofInstant(Instant.ofEpochMilli(node["sys"]["sunset"].asLong() * 1000), TimeZone.getDefault().toZoneId())
        )
        var coordinates = Coordinates(
                latitude = node["coord"]["lat"].asDouble(),
                longitude = node["coord"]["lon"].asDouble()
        )
        var city = City(
                id = node["id"].asLong(),
                name = node["name"].asText(),
                code = node["cod"].asLong(),
                country = node["sys"]["country"].asText(),
                sun = sun,
                coordinates = coordinates
        )

        return Weather(
                name = node["weather"][0]["main"].asText(),
                desc = node["weather"][0]["description"].asText(),
                iconCode = node["weather"][0]["icon"].asText(),
                humidity = humidity,
                pressure = pressure,
                temperature = temperature,
                wind = wind,
                clouds = clouds,
                city = city
        )
    }
}