package fr.hvedrungr.weather.web

import fr.hvedrungr.weather.data.entity.Weather
import fr.hvedrungr.weather.services.WeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("weather")
class WeatherController {

    @Autowired
    lateinit var service: WeatherService

    @GetMapping("/get")
    fun getWeather(@RequestParam(value="city", defaultValue = "Montpellier") city: String): Weather? {
        return service.getWeatherForLocation(city)
    }


}

