package pl.dmcs.stringcalculator.utils;

public class StringCalculator {
    private ICalculatorService calculatorService;

    public StringCalculator(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double compute(String s) {
        return calculatorService.compute(s);
    }
}
