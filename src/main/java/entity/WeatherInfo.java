package entity;

import java.util.Date;

public class WeatherInfo implements WeatherInfoInterface, PrintWeatherInfoInterface {

    public String printWeatherInfo(WeatherParameters weatherInfo) {
        String weather = "";
        String country = "Страна: " + weatherInfo.getCountry();
        String city = " Город: " + weatherInfo.getSity();
        String date =" Дата: " + weatherInfo.getToday();
        String dayPeriod = " Время дня: " + weatherInfo.getDayPeriod();
        String temp = " Температура: " + weatherInfo.getTemperature();
        String humid = " Влажность: " + weatherInfo.getHumidity();
        String press = " Давление: " + weatherInfo.getPressure();
        String windDir = " Направление ветра: " + weatherInfo.getWindDirection();
        String windStrangth = " Сила ветра: " + weatherInfo.getWindStrength();
        weather = country + city + date + dayPeriod + temp + humid + press + windDir + windStrangth;
        return weather;
    }

    public WeatherParameters weatherInfo(String country, String city, Date date) {
        WeatherParameters weather = new WeatherParameters(country, city, date);
        return  weather;
    }
}
