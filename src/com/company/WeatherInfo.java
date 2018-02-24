package com.company;

import java.util.Date;

public class WeatherInfo implements WeatherInfoInterface, PrintWeatherInfoInterface {

    @Override
    public void printWeatherInfo(CurrentWeatherParameters weatherInfo) {
        System.out.println("Дата: " + weatherInfo.getToday());
        System.out.println("Время дня: " + weatherInfo.getDayPeriod());
        System.out.println("Температура: " + weatherInfo.getTemperature());
        System.out.println("Влажность: " + weatherInfo.getHumidity());
        System.out.println("Давление: " + weatherInfo.getPressure());
        System.out.println("Направление ветра: " + weatherInfo.getWindDirection());
        System.out.println("Сила ветра: " + weatherInfo.getWindStrength());
    }

    @Override
    public CurrentWeatherParameters weatherInfo(Date date) {
        CurrentWeatherParameters weather = new CurrentWeatherParameters(date);
        return  weather;
    }
}
