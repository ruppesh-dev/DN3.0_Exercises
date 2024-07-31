package investmentCalculator;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Memoization map to store calculated values
    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method with memoization to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if periods is 0, return the present value
        if (periods == 0) {
            return presentValue;
        }

        // Check if the value for the given periods is already computed
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }

        // Recursive case: calculate the future value for the next period
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);

        // Store the computed value in the memoization map
        memo.put(periods, futureValue);

        return futureValue;
    }

    public static void main(String[] args) {
        // Example usage
        double presentValue = 1000.0; // Present value
        double growthRate = 0.05; // Growth rate (e.g., 5% annual)
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("The estimated value after %d periods is: $%.2f%n", periods, futureValue);
    }
}
