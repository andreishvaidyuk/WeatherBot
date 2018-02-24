package com.company;

import java.util.Random;

public class WeatherParameters {
    private DayPeriod dayPeriod;
    private int temperature;
    private int humidity;
    private int pressure;
    private String windDirection;
    private double windStrength;

    final Random random = new Random();

    WeatherParameters () {
        this.dayPeriod=DayPeriod.MORNING;
        this.temperature=(int)(Math.random()*35);
        this.humidity=(int)(Math.random()*90)+10;
        this.pressure=(int)(Math.random()*100)+700;
        this.windDirection="Nord";
        this.windStrength=(int)(Math.random()*20);
    }

    public DayPeriod getDayPeriod() {
        return dayPeriod;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public double getWindStrength() {
        return windStrength;
    }
}
