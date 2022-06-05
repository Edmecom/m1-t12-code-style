import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y,int d) { 
        /* Лучше назвать переменные не одной буквой, а полным именем, к примеру a = amount, y = yearRate и т.д.*/
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return makeRound(pay, 2);
    } /* После метода в практикуме просят делать пустую строку, чтобы код было легче ситать*/
    double calculateSimplePercent(double doubleAmount,double double_year_rate, int deposit_period) {
        return makeRound(doubleAmount + doubleAmount * double_year_rate * deposit_period, 2);
    } 
    /* В названии переменной дублировать ее тип нет необходимости и нижнее подчеркивание тоже не нужно, просто укажи след слово с большой буквы, к примеру yearRate*/
    double makeRound(double value,int places) { /* Из названия метода непонятно что он делает, лучше конкретнее, к примеру: считает итогувую сумму calculateAmount*/
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calcDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double savings = 0;

        if (action == 1) {
            savings = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2){
            savings = calculateComplexPercent(amount, 0.06, period);
        }
            System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + savings);
    }
    public static void main(String[] args) {
        new DepositCalculator().calcDeposit();
    }
}
