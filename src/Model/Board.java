package Model;

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
            System.out.format("|  %s  ", table[line][i].getInsideOfCell());
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
}
