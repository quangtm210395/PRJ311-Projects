/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteLib;

import java.io.Serializable;

/**
 *
 * @author Rin's
 */
public class Weather implements Serializable{
    private String degree, humidity, wind;

    public Weather(String degree, String humidity, String wind) {
        this.degree = degree;
        this.humidity = humidity;
        this.wind = wind;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
    
    
}
