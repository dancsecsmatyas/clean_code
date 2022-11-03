package org.weather;

import java.io.IOException;
import java.nio.file.Path;

public class WeatherStatistics {

    public static void main(String[] args) throws IOException {
        WeatherFile weatherFile = new WeatherFile();
        weatherFile.setPath(Path.of("src/main/resources/weather.dat"));
        weatherFile.readFile();
        System.out.println(weatherFile.getDayWithTheSmallestDifference());
    }
}
