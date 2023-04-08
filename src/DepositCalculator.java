import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double initialAmount, double annualRate,int years) {
        double pay = initialAmount * Math.pow((1 + annualRate / 12), 12 * years);
        return round(pay, 2);
    }

    double calculateSimplePercent(double initialAmount,double annualRate, int years) {
        return round(initialAmount + initialAmount * annualRate * years, 2);
    }

    double round(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateContribution() {
        int years;
        int action;

        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int initialAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        years = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0;
        if (action ==1) {
            outDoubleVar = calculateSimplePercent(initialAmount, 0.06, years);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(initialAmount, 0.06, years);
        }
        System.out.println("Результат вклада: " + initialAmount + " за " + years + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
}
