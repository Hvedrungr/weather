package fr.hvedrungr.weather.services

import fr.hvedrungr.weather.client.OpenWeatherDataClientService
import fr.hvedrungr.weather.data.entity.Weather
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WeatherService {

    @Autowired
    lateinit var client: OpenWeatherDataClientService

    fun getWeatherForLocation(city: String): Weather? {
        return client.getWeather(city)
    }
}