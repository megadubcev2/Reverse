package View;

import java.util.Scanner;

import Controller.Coordinates;

public class UserInterface {
    final Scanner in = new Scanner(System.in);

    public Coordinates askCoordinates() {
        System.out.printf("Введите координаты вашего хода (например: '1a'): ");
        String answer = in.nextLine();
        Coordinates coordinates;
        while(true){
            if (!isCorrectCoordinates(answer)) {
                System.out.println("Некорректный ввод попробуйте еще раз)");
                System.out.printf("Введите координаты вашего хода (например: '1a'): ");
                answer = in.nextLine();
            } else {
                coordinates = transformToCoordinates(answer);

            }
        }

    }

    private boolean isCorrectCoordinates(String strCoordinates) {
        if (strCoordinates.length() != 2) {
            return false;
        }
        char i = strCoordinates.charAt(0);
        char j = strCoordinates.charAt(1);
        if (!(i >= '1' && i <= '8')) {
            return false;
        }
        if (!(j >= 'a' && j <= 'h')) {
            return false;
        }
        return true;
    }

    private Coordinates transformToCoordinates(String strCoordinates) {
        int i = strCoordinates.charAt(0) - '1';
        int j = strCoordinates.charAt(1) - 'a';
        return new Coordinates(i, j);
    }

}
