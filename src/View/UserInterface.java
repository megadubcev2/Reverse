package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Coordinates;
import Controller.Game;
import Model.TypeOfChip;

public class UserInterface {
    final Scanner in = new Scanner(System.in);


    public Coordinates askCoordinates(Game game) {

        printCellsPossiblePutChips(game.getCellsPossiblePutChips());
        System.out.printf("Введите координаты вашего хода: ");
        String answer = in.nextLine();
        Coordinates coordinates;
        while (true) {
            if (!isCorrectCoordinates(answer)) {
                System.out.println("Некорректный ввод попробуйте еще раз)");
                printCellsPossiblePutChips(game.getCellsPossiblePutChips());
                System.out.printf("Введите координаты вашего хода: ");
                answer = in.nextLine();
            } else {
                coordinates = transformToCoordinates(answer);
                if (game.isPossiblePutChip(coordinates)) {
                    return coordinates;
                } else {
                    System.out.println("Вы не можете поставить туда фишку)");
                    printCellsPossiblePutChips(game.getCellsPossiblePutChips());
                    System.out.printf("Введите координаты вашего хода: ");
                    answer = in.nextLine();
                }
            }
        }
    }

    private void printCellsPossiblePutChips(ArrayList<Coordinates> cellsPossiblePutChips) {
        System.out.printf("Возможные ходы: [" + cellsPossiblePutChips.get(0));
        for (int i = 1; i < cellsPossiblePutChips.size(); i++) {
            System.out.printf(", " + cellsPossiblePutChips.get(i));
        }
        System.out.println("]");
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

    public void printTurnUser(TypeOfChip turnUser) {
        System.out.printf("Ход ");

        if (turnUser == TypeOfChip.CHIP_BLACK) {
            System.out.println("черных");
        } else if (turnUser == TypeOfChip.CHIP_WHITE) {
            System.out.println("белых");
        }
    }


    public void printWinner(TypeOfChip winner) {
        if (winner == TypeOfChip.CHIP_BLACK) {
            System.out.println("Черные победили!!!");
        } else if (winner == TypeOfChip.CHIP_WHITE) {
            // System.out.println("Вaйт пaвeр!!!");
            // осуждаю
            System.out.println("Белые победили!!!");
        } else if (winner == TypeOfChip.EMPTY) {
            System.out.println("Ничья!!!");
        }
    }

    public void countdown() {
        int n = 3;
        for (int i = n; i >= 1; i--) {
            System.out.printf(i + ".. ");
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void printStep(Coordinates coordinates, TypeOfChip turnUser){
        if (turnUser == TypeOfChip.CHIP_BLACK) {
            System.out.printf("Черные сходили на ");
        } else if (turnUser == TypeOfChip.CHIP_WHITE) {
            System.out.printf("Белые сходили на ");
        }
        System.out.println(coordinates.toString());
    }
}
