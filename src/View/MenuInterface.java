package View;

import java.util.Scanner;

public class MenuInterface {
    final static Scanner in = new Scanner(System.in);

    public static int askVariant() {
        System.out.println("1. Игра с компьютером");
        System.out.println("2. Игра для двоих");
        System.out.println("3. Выход");
        String answer;
        int variant;
        while (true) {
            try {
                System.out.printf("Введите номер команды: ");
                answer = in.next();
                variant = Integer.parseInt(answer);
                if (variant >= 1 && variant <= 3) {
                    break;
                }
            } catch (Exception e) {
                //
            }
            System.out.println("Некорректный ввод, попробуйте еще раз)");
        }
        return variant;
    }

    public static void printGoodbue() {
        System.out.println("До свидания, приходите еще)");
    }
}
