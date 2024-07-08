package C2FApp.observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subcriber> subcribers = new ArrayList<>();

    public void subcribe(Subcriber subcriber) {
        subcribers.add(subcriber);
    }

    public void unSubcriber(Subcriber subcriber) {
        subcribers.remove(subcriber);
    }

    public void notifyChangeCelsius() {
        for (Subcriber subcriber : subcribers) {
            subcriber.updateCelsius();
        }
    }

    public void notifyChangeFahrenheit() {
        for (Subcriber subcriber : subcribers) {
            subcriber.updateFahrenheit();
        }
    }
}
