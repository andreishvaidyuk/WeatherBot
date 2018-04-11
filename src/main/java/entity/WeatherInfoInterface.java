package entity;

import java.util.Date;

public interface WeatherInfoInterface {
    WeatherParameters weatherInfo (String country, String city, Date date);
}
