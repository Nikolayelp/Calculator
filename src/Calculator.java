import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
//    BinaryOperator<Integer> divide = (x, y) -> x / y;
//    Происходит деление на 0. Проверка делителя не осуществляется
//    В случае делителя = 0 можно либо прервать программу и выбросить исключение, либо вернуть какое-либо значение,
//    не выполняя деление
//    Вариант проверки и возврата делимого в случае деления на 0:
//    BinaryOperator<Integer> divide = (x, y) -> y == 0 ? x: x / y;

//    Вариант возврата делимого с обработкой исключений:
//    BinaryOperator<Integer> divide = (x, y) -> {
//        try {
//            return x / y;
//        } catch (ArithmeticException e) {
//            System.out.println("Была бессмысленная попытка деления на 0: x = " + x + ", y = " + y + ". Возвращаем значение x = " + x);
//            return x;
//        }
//    };

//    Вариант выброса исключения:
    BinaryOperator<Integer> divide = (x, y) -> {
        if (y == 0) {
            throw new ArithmeticException("Была бессмысленная попытка деления на 0! Доработай программу!");
        } else return x / y;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
