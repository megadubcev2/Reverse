package View;

import java.util.Scanner;

import Controller.Coordinates;

public class UserInterface {
    final Scanner in = new Scanner(System.in);

    public Coordinates askCoordinates() {
        System.out.printf("Введите координаты вашего хода (например: '1a'): ");
        String answer = in.nextLine();
        if (!isCorrectCoordinates(answer)) {
            System.out.printf("Некорректный ввод попробуйте еще раз)");
        } else {
            System.out.println("Молодец");
        }
        return new Coordinates();
    }

    private boolean isCorrectCoordinates(String coordinates) {
        if (coordinates.length() != 2) {
            return false;
        }
        char i = coordinates.charAt(0);
        char j = coordinates.charAt(1);
        if (!(i >= '1' && i <= '8')) {
            return false;
        }
        if (!(j >= 'a' && j <= 'h')) {
            return false;
        }
        return true;
    }
}
