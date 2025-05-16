package Model;

public class carModel {

    private String registration;
    private String make;
    private String model;
    private String year;

    // Constructor
    public carModel(String registration, String make, String model, String year) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

}
