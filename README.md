# weather
Get weather data for cities

Projet en cours d'écriture, utilisé principalement pour découvrir Kotlin.

En l'état, permet de récupérer la météo en temps réel pour une ville passée en paramètre (default Montpellier) :
 -> /weather/get?city={YOUR_CITY}
 
 S'appuie sur l'API OpenWeatherMap, nécessite de s'enregistrer sur ce service (https://openweathermap.org/api)
 Pour utiliser, nécessite de rajouter dans votre ficher application.properties :
-> app.id = YOUR_API_KEY}
-> app.url = https://api.openweathermap.org/data/2.5/weather
-> app.params = lang=fr&units=metric
