package C2FApp;

import C2FApp.observer.Publisher;

public class Model extends Publisher {
    private double celsius;
    private double fahrenheit;

    public void c2f(double c) {
        this.fahrenheit = (c * 9 / 5) + 32;
        changeFahrenheit();
    }

    public void f2c(double f) {
        this.celsius = (f - 32) * 5 / 9;
        changeCelsius();
    }

    private void changeCelsius() {
        notifyChangeCelsius();
    }

    private void changeFahrenheit() {
        notifyChangeFahrenheit();
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }
}
