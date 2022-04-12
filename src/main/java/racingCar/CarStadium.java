package racingCar;

import java.util.LinkedList;
import java.util.Random;

public class CarStadium {

    private static final int BOUND = 10;

    private static final Random random = new Random();

    private static LinkedList<Car> carList = new LinkedList<>();
    private static int rounds = 0;

    public static int extractRandomNumber() {
        return random.nextInt(BOUND);
    }

    public static void initCars(int nums) {
        for (int i = 0; i < nums; ++i) {
            Car car = new Car(new NormalStrategy());
            carList.add(car);
        }
    }

    public static void initRounds(int nums) {
        rounds = nums;
    }

    public static int getRounds() {
        return rounds;
    }

    public static LinkedList<Car> getCars() {
        return carList;
    }
}
