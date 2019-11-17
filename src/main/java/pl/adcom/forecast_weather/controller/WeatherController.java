package pl.adcom.forecast_weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.adcom.forecast_weather.model.Weather;
import pl.adcom.forecast_weather.service.WeatherService;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //    public WeatherController() {
//        this.restTemplate = new RestTemplate();
//        Weather forObject = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=Warsaw&units=metric&APPID=e4ca033fa0ee55203d5de8891c986cc8", Weather.class);
//
//        String tempNo = Integer.toString(forObject.getMain().getTemp());
//        String tempMax = Double.toString(forObject.getMain().getTempMax());
//        String presure = Integer.toString(forObject.getMain().getPressure());
//        String iconNo = forObject.getWeather().get(0).getIcon();
//
//        System.out.println("Temperatura : " + tempNo + " C Najwyższa temperatura : " + tempMax + " C ciśnienie " + presure + " HPa");
//        System.out.println("http://openweathermap.org/img/w/" + iconNo + ".png");
////        System.out.println(forObject);
//    }

    @GetMapping("/weather")
    public String showWeather(Model model){
        model.addAttribute("weather", weatherService.getParamiters());
        model.addAttribute("urlIcon", weatherService.getUrl());
        return "weather";
    }


}
