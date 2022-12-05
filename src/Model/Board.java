package Model;

import Controller.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Board {
    final int len = 8;
    public Cell[][] table;

    public Board() {
        table = new Cell[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                table[i][j] = new Cell();
            }
        }
        table[3][3].setInsideOfCell(TypeOfChip.CHIP_WHITE);
        table[4][4].setInsideOfCell(TypeOfChip.CHIP_WHITE);
        table[3][4].setInsideOfCell(TypeOfChip.CHIP_BLACK);
        table[4][3].setInsideOfCell(TypeOfChip.CHIP_BLACK);
    }

    private void printPartition() {
        System.out.printf("  ");

        for (int i = 0; i < len; i++) {
            System.out.printf(" -----");
        }
        System.out.println();
    }

    private void printLine(int line) {
        System.out.printf(line + 1 + " ");
        for (int i = 0; i < len; i++) {
            System.out.format("|  %s  ", table[line][i].toString());
        }
        System.out.println("|");
    }

    private void printLineOfLetters() {
        System.out.printf("  ");
        for (int i = 0; i < len; i++) {
            System.out.format("   %c  ", 'a' + i);
        }
        System.out.println();
    }

    public void printBoard() {
        printLineOfLetters();
        for (int i = 0; i < len; i++) {
            printPartition();
            printLine(i);
        }
        printPartition();
    }

    private void updatePossibilityCell(TypeOfChip turnUser, int i, int j) {
        if(table[i][j].getInsideOfCell() != TypeOfChip.EMPTY){
            table[i][j].setPossiblePutChip(turnUser, false);
            return;
        }

        boolean possiblePutChip = false;
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (k == i && l == j){
                    continue;
                }
                if(Coordinates.existCoordinates(k,l)){
                    possiblePutChip = possiblePutChip || (table[k][l].getInsideOfCell() == turnUser);
                }
            }
        }
        table[i][j].setPossiblePutChip(turnUser, possiblePutChip);
    }

    public void updatePossibilityBoard(TypeOfChip turnUser) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                updatePossibilityCell(turnUser, i, j);
            }
        }
    }

}
