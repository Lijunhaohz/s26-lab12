package edu.cmu.Weather;

public class Weather {
    private WeatherService weatherService;
    private LengthScale lengthScale;

    /**
     * Sets the length scale for rainfall.
     *
     * @param lengthScale the scale of length to use for rainfall measurements.
     */
    public void setLengthScale(LengthScale lengthScale) {
        this.lengthScale = lengthScale;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount. If the measurement is in inches, it returns the value as is.
     *         If the measurement is not in inches, it converts the value to millimeters.
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall();
        if (lengthScale == LengthScale.INCHES) {
            return wsRainfall / 25.4;
        } else {
            // Suppose that lengthScale is INCHES or MILLIMETERS
            return wsRainfall;
        }
    }
}
