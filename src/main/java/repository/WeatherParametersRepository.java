package repository;

import entity.WeatherParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface WeatherParametersRepository extends JpaRepository<WeatherParameters, Long> {

    @Query("select w from WeatherParameters wp where w.date = :date")
    WeatherParameters findByDate (@Param("date") Date date);
}
