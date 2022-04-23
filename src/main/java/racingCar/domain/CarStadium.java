package racingCar.domain;

import racingCar.view.InputViewRacingCar;
import racingCar.view.ResultViewRacingCar;


public class CarStadium {

    private Cars carList = new Cars();
    private int rounds = 0;

    public void startRacing() {
        initRacingData();

        moveAndViewRacingCar();

        resultViewRacing();
    }

    private void initRacingData() {
        initCars(InputViewRacingCar.inputPlayCarNum());
        initRounds(InputViewRacingCar.inputRounds());
    }

    private void initCars(String[] carNames) {
        carList.initCars(carNames);
    }

    private void initRounds(int nums) {
        rounds = nums;
    }

    private void moveAndViewRacingCar() {
        for(int i = 0; i < rounds; i++) {
            moveCars();
            ResultViewRacingCar.resultViewCarData(carList.getCarList());
        }
    }

    private void moveCars() {
        carList.moveCars();
    }

    private void resultViewRacing() {
        ResultViewRacingCar.resultViewWinners(carList.getWinners());
    }
}
