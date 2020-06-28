package lb3;
import java.util.Scanner;

public class TestArrayMedian {

    public static void main(String[] args) {
        ArrayMedian arrayMedian = new ArrayMedian(12);

        Scanner scanner = new Scanner(System.in);
        String input;
        int number = 0;

        System.out.println("Введите номер: ");

        while (true) {

            input = scanner.nextLine();
            if (input.equals("q") || input.equals("exit")) break;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неправильый аргумент");
                continue;
            }
            arrayMedian.push(number);
            int median = (int) arrayMedian.getMedian();
            System.out.println("Теперь медиана: " + median);
        }
        scanner.close();
    }
}
