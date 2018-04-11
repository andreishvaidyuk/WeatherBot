package service;

import entity.WeatherParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import repository.WeatherParametersRepository;

import java.util.Date;
import java.util.List;

@Service
public class WeatherParametersServiceImpl implements WeatherParametersService {

    @Autowired
    private WeatherParametersRepository weatherParametersRepository;

    public WeatherParameters addWeatherParameters(WeatherParameters weatherParameters) {
        WeatherParameters savedWeatherParameters = weatherParametersRepository.saveAndFlush(weatherParameters);

        return  savedWeatherParameters;
    }

    public void delete(long id) {
        weatherParametersRepository.deleteById(id);
    }

    public WeatherParameters getByDate(Date today) {
        return weatherParametersRepository.findByDate(today);
    }

    public List<WeatherParameters> getAll() {
        return weatherParametersRepository.findAll();
    }
}
