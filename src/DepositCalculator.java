import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.calculateDeposit();
    }

    double calculateComplexPercent(double rubAmount, double yearRate, int depositPeriod) {
        double payout = rubAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundAmount(payout, 2);
    }

    double calculateSimplePercent(double rubAmount, double yearRate, int depositPeriod) {
        return roundAmount(rubAmount + rubAmount * yearRate * depositPeriod, 2);
    }

    double roundAmount(double value, int digit) {
        double scale = Math.pow(10, digit);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int rubAmount;
        int depositPeriod;
        int action;
        double rubAmountAfterDeposit = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        rubAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            rubAmountAfterDeposit = calculateSimplePercent(rubAmount, 0.06, depositPeriod);
        } else if (action == 2) {
            rubAmountAfterDeposit = calculateComplexPercent(rubAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + rubAmount + " за " + depositPeriod + " лет превратятся в "
                + rubAmountAfterDeposit);
    }
}
