package demo05builderPattern;

/**
 * Javan 2021.02.21
 */
public class drive {
    public static void main(String[] args) {
        //非Builder模式
        Car car = new Car("engine", "chassis", "body", "equipment");
        //Builder模式
        NewCar newCar = new NewCar.Builder().engine("engine").chassis("chassis").body("body").equipment("equipment").build();

    }
}
