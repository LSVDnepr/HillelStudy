package hometask05.hometask0504cars;



public class CarTypesMain {
    /*Задание
    1.Реализовать перечисление типов автомобилей (CarType):
Sedan (Lada Granta, Volvo V60, Renault Logan, Lifan Solano)
Limousine (ЗИЛ-41047, Mercedes-Benz W100, Lincoln Town Car)
SportCar (Mazda, Mclaren 570GT, Bugatti Vision Gran Turismo, Acura NSX)
CrossOver (Renault Duster, Chevrolet Niva, Nissan Terrano)
HatchBack (Skoda Fabia, KIA Ceed, Renault Sandero)
2.Реализовать методы:
2.1.получения марок конкретного типа авто.
2.2.получения макс-го/мин-го объема двигателя для конкретного типа авто.
3. Вывести все модели, всех типов.
     */


    public static void main(String[] args) {

        //2.1. получение марок конкретного типа авто:
        // CarType.SEDAN.getCarModels().forEach(carModel -> System.out.println(carModel.getModel()));
        //или так (на мой взгяд, это избыточный метод, достаточно решения выше)
        CarType.SEDAN.buildCarModelNames().forEach(s -> System.out.print(s + ", "));
        System.out.println("\b\b\n");

        //Получение максимального и минимального объема двигателя для конкретного типа авто
        System.out.println("Максимальный объем двигателя для " + CarType.SEDAN + "=" + CarType.SEDAN.getMaxEngineCapacity());
        System.out.println("Минимальный объем двигателя для " + CarType.CROSSOVER + "=" + CarType.CROSSOVER.getMinEngineCapacity());


        //Вывести все модели всех типов
        for (CarType c : CarType.values()) {
            c.getCarModels().forEach(System.out::println);
        }

    }


}
