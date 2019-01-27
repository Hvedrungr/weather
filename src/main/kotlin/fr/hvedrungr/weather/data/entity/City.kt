package fr.hvedrungr.weather.data.entity

data class City(
        var id: Long,
        var name: String,
        var code: Long,
        var country: String,
        var sun: Sun,
        var coordinates: Coordinates
)