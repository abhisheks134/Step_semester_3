package day_1.class_problems;

public class BmiCalculator {

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.82, 1.68, 1.55,
                            1.72, 1.80, 1.65, 1.70, 1.90};

        double[] weights = {70, 90, 82, 55, 48,
                            75, 100, 62, 68, 85};

        printWellnessReport(heights, weights);
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("BMI Wellness Report");
        System.out.printf("%-8s %-12s %-13s %-10s %s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-8d %-12.2f %-13.1f %-10.2f %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}