import java.awt.geom.QuadCurve2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1: ");
        System.out.println("Введите дату своего рождения в формате dd/MM/yyyy: ");
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        localDate(year);

        System.out.println();

        System.out.println("Задание 2: ");
        Integer[] arr = {0, -2, 2, 4};
        Predicate<Integer> isPositive = x -> x > 0;
        Arrays.stream(arr)
                .filter(isPositive)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Задание 3 (введите сумму в форматя СУММА BYN) :");
        String sum = scanner.nextLine();
        Function<String, Double> dollars = x -> Double.parseDouble(x.split(" ")[0])/3.18;
        System.out.println("В долларах: "+dollars.apply(sum));

        System.out.println();

        System.out.println("Задание 4 (введите сумму в форматя СУММА BYN) :");
        Consumer<String> toDollars = x -> System.out.println("В долларах:"+Double.parseDouble(x.split(" ")[0])/3.18);
        toDollars.accept(sum);

        System.out.println();

        backwards();


    }
    public static void localDate(String year){
        LocalDate localDate = LocalDate.parse(year, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusYears(100);
        System.out.println("дата, когда пользователю исполнится 100 лет: "+ localDate);
    }
    public static void backwards(){
        System.out.println("Задание 5: ");
        Supplier<String> backwardsString = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите строку: ");
            String line = scanner.nextLine();
            String s = new StringBuilder(line).reverse().toString();
            return s;
        };

        System.out.println(backwardsString.get());
    }
}