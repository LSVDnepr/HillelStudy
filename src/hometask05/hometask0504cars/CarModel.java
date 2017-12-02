package hometask05.hometask0504cars;

public class CarModel {
    private String model;
    private int engineCapacity;
    private CarType cT;

    public CarModel(String model, int engineCapacity, CarType cT) {
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.cT = cT;
    }

    public String getModel() {
        return model;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public CarType getcT() {
        return cT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModel carModel = (CarModel) o;

        if (engineCapacity != carModel.engineCapacity) return false;
        if (!model.equals(carModel.model)) return false;
        return cT == carModel.cT;
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + engineCapacity;
        result = 31 * result + cT.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CarType: " + cT + ", model: " + model + ", engine capacity: " + engineCapacity;

    }

}
