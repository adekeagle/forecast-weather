package pl.adcom.forecast_weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.adcom.forecast_weather.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {

    RestTemplate restTemplate = new RestTemplate();
    Weather weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=Venezia&units=metric&APPID=e4ca033fa0ee55203d5de8891c986cc8", Weather.class);

    @Override
    public Weather getParamiters() {
        return weather;
    }

    @Override
    public String getUrl() {
        return "http://openweathermap.org/img/w/" + weather.getWeather().get(0).getIcon() + ".png";
    }


}
