package carracing.controller;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.RandomCondition;
import carracing.domain.Winners;
import carracing.exception.CarNameFormatException;
import carracing.view.InputInfo;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

/*
 * CarRacing
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class CarRacing {

    public InputInfo racingQuestion() {
        InputView inputView = new InputView();
        String carNameList = inputView.carNameQuestion();
        String tryCount = inputView.tryCountQuestion();
        return new InputInfo(carNameList, tryCount);
    }

    public void racingStart(InputInfo inputInfo) throws CarNameFormatException {

        ResultView resultView = new ResultView();
        List<Car> carList = new ArrayList<>();

        createCarNameList(inputInfo, carList);

        Cars cars = new Cars(carList);
        for (int i = 0; i < inputInfo.getTryCount(); i++) {
            racing(cars, inputInfo);                 /* 시도 횟수 만큼 주행 */
            resultView.printRacing(cars);            /* 시도 횟수 만큼 출력 */
        }

        Winners winners = cars.getWinner();
        resultView.printWinner(winners);
    }

    private void createCarNameList(InputInfo inputInfo, List<Car> carList) throws CarNameFormatException {
        List<String> carStringList = inputInfo.getCarStringList();
        for (int i = 0; i < inputInfo.getCarCount(); i++) {
            String carName = carStringList.get(i);
            carList.add(new Car(carName));
        }
    }

    public void racing(Cars carList, InputInfo inputInfo) {
        for (int i = 0; i < inputInfo.getCarCount(); i++) {
            Car car = carList.get(i);
            int condition = RandomCondition.getCondition();
            car.driving(condition);
        }
    }

}