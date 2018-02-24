package com.company;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        WeatherInfo info = new WeatherInfo();

        CurrentWeatherParameters weather = info.weatherInfo(date);
	    info.printWeatherInfo(weather);

    }
}
