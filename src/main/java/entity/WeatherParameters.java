package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "weatherParam")
public class WeatherParameters {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="Id")
    private Long Id;

    @Column(name="date")
    private Date today;

    @Column(name = "country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="dayPeriod")
    private DayPeriod dayPeriod;

    @Column(name="temperature")
    private double temperature;

    @Column(name="humidity")
    private int humidity;

    @Column(name="pressure")
    private int pressure;

    @Column(name="windDirection")
    private String windDirection;

    @Column(name="windStrength")
    private double windStrength;

    final Random random = new Random();

    WeatherParameters (String country, String city, Date today) {
        this.today=today;
        this.dayPeriod=DayPeriod.MORNING;
        this.country=country;
        this.city=city;
        this.temperature=(int)(Math.random()*35);
        this.humidity=(int)(Math.random()*90)+10;
        this.pressure=(int)(Math.random()*100)+700;
        this.windDirection="Nord";
        this.windStrength=(int)(Math.random()*20);
    }

    public Date getToday() { return today; }

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

    public String getCountry() { return country; }

    public String getSity() { return city; }
}
