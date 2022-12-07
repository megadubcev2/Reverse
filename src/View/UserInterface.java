package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Coordinates;
import Controller.Game;
import Model.TypeOfChip;

public class UserInterface {
    final Scanner in = new Scanner(System.in);

    public Coordinates askCoordinates(Game game) {
        printTurnUser(game.getTurnUser());
        printCellsPossiblePutChips(game.getCellsPossiblePutChips());
        System.out.printf("Введите координаты вашего хода: ");
        String answer = in.nextLine();
        Coordinates coordinates;
        while(true){
            if (!isCorrectCoordinates(answer)) {
                System.out.println("Некорректный ввод попробуйте еще раз)");
                printCellsPossiblePutChips(game.getCellsPossiblePutChips());
                System.out.printf("Введите координаты вашего хода: ");
                answer = in.nextLine();
            } else {
                coordinates = transformToCoordinates(answer);
                if(game.isPossiblePutChip(coordinates)){
                    return coordinates;
                }
                else{
                    printCellsPossiblePutChips(game.getCellsPossiblePutChips());
                    System.out.printf("Введите координаты вашего хода: ");
                    answer = in.nextLine();
                }
            }
        }
    }

    private void printCellsPossiblePutChips(ArrayList<Coordinates> cellsPossiblePutChips){
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

    private void printTurnUser(TypeOfChip turnUser){
        System.out.printf("Ход ");

        if(turnUser == TypeOfChip.CHIP_BLACK){
            System.out.println("черных");
        }
        else if (turnUser == TypeOfChip.CHIP_WHITE){
            System.out.println("белых");
        }
    }

    public void printGoodbue(){
        System.out.println("До свидания, приходите еще)");
    }

}
