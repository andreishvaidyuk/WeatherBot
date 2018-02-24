package com.company;

import java.util.Date;

public class CurrentWeatherParameters extends WeatherParameters {
    private Date today;

    CurrentWeatherParameters (Date today) {
        this.today = today;
    }

    public Date getToday() {
        return today;
    }
}
