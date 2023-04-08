import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double initialAmount, double annualRate,int years) {//TODO initialAmount и
        // annualRate - отличный выбор для названия параметров
        double pay = initialAmount * Math.pow((1 + annualRate / 12), 12 * years);
        return round(pay, 2);
    }

    double calculateSimplePercent(double initialAmount,double annualRate, int years) {
        return round(initialAmount + initialAmount * annualRate * years, 2);
    }

    double round(double value, int places) {
        double scaLe = Math.pow(10, places); //TODO в переменной scaLe должны быть все буквы строчными, p.s. у меня такая же ошибка :(
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateContribution() { //TODO я в английском не native, но Contribution мне режет глаз,
        // все-таки в банковской терминологии "вклад" - это deposit, а contribution означает нематериальный вклад.
        //плюс сам метод содержит не только вычисление итоговой суммы на счету, но и взаимодействует с пользователем,
        //поэтому, возможно, calculate - не самый точный глагол для описания метода.

        int years; //TODO я бы рассмотрел более точное название для переменной, может быть, yearCount или depositPeriod
        int action;

        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int initialAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        years = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0; //TODO нет необходимости указывать тип переменной (DoubleVar), также слово out можно
        // трактовать по-разному, я бы заменил на слово означающие итог, например, result.
        if (action ==1) { //TODO отсутсвует пробел после ==
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
