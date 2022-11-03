package org.weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherFile {

    private Path path;

    private List<WeatherRow> weatherRows;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public List<WeatherRow> getWeatherRows() {
        return weatherRows;
    }

    public void setWeatherRows(List<WeatherRow> weatherRows) {
        this.weatherRows = weatherRows;
    }

    public void readFile() throws IOException {
        List<WeatherRow> weatherRows = new ArrayList<>();
        Files.lines(getPath()).forEach(line -> {
            if (isValidLine(line)) {
                addRow(weatherRows, line);
            }
        });
        setWeatherRows(weatherRows);
    }

    public int getDayWithTheSmallestDifference() {
        List<WeatherRow> weatherRowList = getWeatherRows();
        int smallestDifference = Integer.MAX_VALUE;
        int day = 0;
        for (int i = 0; i < weatherRowList.size(); i++) {
            if(weatherRowList.get(i).temperatureDifference() < smallestDifference) {
                smallestDifference = weatherRowList.get(i).temperatureDifference();
                day = weatherRowList.get(i).getDay();
            }
        }
        return day;
    }

    private boolean isValidLine(String line) {
        return line.trim().length() > 0 && line.trim().substring(0, 1).matches("[+-]?\\d+");
    }

    private void addRow(List<WeatherRow> weatherRows, String line) {
        WeatherRow weatherRow = new WeatherRow();
        setWeatherRowDetails(line, weatherRow);
        weatherRows.add(weatherRow);
    }

    private void setWeatherRowDetails(String line, WeatherRow weatherRow) {
        weatherRow.setDay(Integer.parseInt(line.substring(2, 4).trim()));
        weatherRow.setMaxTemperature(Integer.parseInt(line.substring(6, 8).trim()));
        weatherRow.setMinTemperature(Integer.parseInt(line.substring(12, 14).trim()));
    }
}
