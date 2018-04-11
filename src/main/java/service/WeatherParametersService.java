package service;

import entity.WeatherParameters;

import java.util.Date;
import java.util.List;

public interface WeatherParametersService {

    WeatherParameters addWeatherParameters (WeatherParameters weatherParameters);
    void delete (long id);
    WeatherParameters getByDate (Date today);
    List<WeatherParameters> getAll();
}
