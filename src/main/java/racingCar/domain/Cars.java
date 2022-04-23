package racingCar.domain;

import racingCar.NormalStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    private static final Random random = new Random();
    private static final int BOUND = 10;

    public static int extractRandomNumber() {
        return random.nextInt(BOUND);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void initCars(String[] carNames) {
        for (String name : carNames) {
            Car car = new Car(name, new NormalStrategy());
            carList.add(car);
        }
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move(extractRandomNumber());
        }
    }

    public List<String> getWinners() {
        List<String> winners = findWinners(carList, getMaxPosition(carList));

        return winners;
    }

    private static List<String> findWinners(List<Car> cars, int max) {
        List<String> winners = new ArrayList<>();

        for (int j = 0; j < cars.size(); ++j) {
            Car car = cars.get(j);
            addWinners(max, winners, car);
        }

        return winners;
    }

    private static void addWinners(int max, List<String> winners, Car car) {
        if (max == car.getPosition()) {
            winners.add(car.getName());
        }
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (int j = 0; j < cars.size(); ++j) {
            int position = cars.get(j).getPosition();
            maxPosition = getMaxPosition(maxPosition, position);
        }
        return maxPosition;
    }

    private static int getMaxPosition(int maxPosition, int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
        return maxPosition;
    }
}
