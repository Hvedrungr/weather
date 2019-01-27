package fr.hvedrungr.weather.client

import fr.hvedrungr.weather.data.entity.Weather
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class OpenWeatherDataClientService {

    @Value("\${app.url}")
    val appUrl: String? = null


    @Value("\${app.id}")
    val appId: String? = null

    @Value("\${app.params}")
    val appParams: String? = null

    fun getWeather(city: String): Weather? {
        return RestTemplate().getForObject("$appUrl?q=$city&appid=$appId&$appParams")
    }
}