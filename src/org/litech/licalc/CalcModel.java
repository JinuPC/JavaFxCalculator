package org.litech.licalc;

/**
 * Created by Jinu on 17-07-2016.
 */public class CalcModel {

    /*
     * Method for doing current operation
     */
    public long doTask(String firstNumber, String secondNumber, String operator) {
        long result = 0l;
        long first = Long.parseLong(firstNumber);
        long second = Long.parseLong(secondNumber);
        switch (operator){
            case "+" :
                return first + second;
            case "-" :
                return first - second;
            case "x" :
                return first * second;
            case "/" :
                if(second == 0)
                {
                    return 0;
                }
                return first / second;
        }

        return result;
    }
}
