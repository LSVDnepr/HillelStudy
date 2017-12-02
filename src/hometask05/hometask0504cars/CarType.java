package hometask05.hometask0504cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public enum CarType {
    SEDAN {
        @Override
        protected void formCarModelsList() {
            addCarModel(new CarModel("Lada Granta", 1597, this));//sm3
            addCarModel(new CarModel("Volvo V60", 1596, this));
            addCarModel(new CarModel("Renault Logan", 1461, this));
            addCarModel(new CarModel("Lifan Solano", 1794, this));

        }
    }, LIMOUSINE {
        @Override
        protected void formCarModelsList() {
            addCarModel(new CarModel("ЗИЛ-41047", 7680, this));//sm3
            addCarModel(new CarModel("Mercedes-Benz W100", 6332, this));
            addCarModel(new CarModel("Lincoln Town Car", 4900, this));
        }
    }, SPORTCAR {
        @Override
        protected void formCarModelsList() {
            addCarModel(new CarModel("Mazda RX-7", 1300, this));//sm3
            addCarModel(new CarModel("Mclaren 570GT", 3799, this));
            addCarModel(new CarModel("Bugatti Vision Gran Turismo", 8000, this));
            addCarModel(new CarModel("Acura NSX", 3200, this));//sm3

        }
    }, CROSSOVER {
        @Override
        protected void formCarModelsList() {
            addCarModel(new CarModel("Renault Duster", 1500, this));//sm3
            addCarModel(new CarModel("Chevrolet Niva", 1700, this));
            addCarModel(new CarModel("Nissan Terrano", 2000, this));

        }
    }, HATCHBACK {
        @Override
        protected void formCarModelsList() {
            addCarModel(new CarModel("Skoda Fabia Mk3", 1600, this));//sm3//ok
            addCarModel(new CarModel("KIA Ceed", 1975, this));//ok
            addCarModel(new CarModel("Renault Sandero", 1500, this));

        }
    };


    private int maxEngineCapacity = Integer.MIN_VALUE;
    private int minEngineCapacity = Integer.MAX_VALUE;
    protected ArrayList<CarModel> carModels = new ArrayList<>();


    public void addCarModel(CarModel car) {
        carModels.add(car);
        if (car.getEngineCapacity() > maxEngineCapacity) maxEngineCapacity = car.getEngineCapacity();
        if (car.getEngineCapacity() < minEngineCapacity) minEngineCapacity = car.getEngineCapacity();
    }


    public List<CarModel> getCarModels() {
        return Collections.unmodifiableList(carModels);
    }

    public List<String> buildCarModelNames() {
        List<String> modelsname = new LinkedList<>();
        for (CarModel c : carModels) {
            modelsname.add(c.getModel());
        }
        return Collections.unmodifiableList(modelsname);
    }


    public int getMaxEngineCapacity() {
        return this.maxEngineCapacity;
    }


    public int getMinEngineCapacity() {
        return this.minEngineCapacity;
    }


    CarType() {
        formCarModelsList();
    }

    protected abstract void formCarModelsList();


}
