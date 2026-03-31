package edu.cmu.Weather;

public class Weather {
    private WeatherService weatherService;
    private boolean inches;

    /**
     * Sets the length scale for rainfall.
     *
     * @param inches if true, sets the scale to inches; if false, sets the scale to millimeters.
     */
    public void setLengthScale(boolean inches) {
        this.inches = inches;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount. If the measurement is in inches, it returns the value as is.
     *         If the measurement is not in inches, it converts the value to millimeters.
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall();
        if (inches) {
            return wsRainfall / 25.4;
        } else {
            return wsRainfall;
        }
    }
}
