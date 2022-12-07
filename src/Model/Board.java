package Model;

import Controller.Coordinates;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {
    final int len = 8;
    private Cell[][] table;

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
        if (table[i][j].getInsideOfCell() != TypeOfChip.EMPTY) {
            table[i][j].setPossiblePutChip(turnUser, false);
            return;
        }
        if (!isNextToOpponentChip(turnUser, i, j)) {
            table[i][j].setPossiblePutChip(turnUser, false);
            return;
        }

        boolean possiblePutChip = isClosed(turnUser, i, j);
        table[i][j].setPossiblePutChip(turnUser, possiblePutChip);
    }

    private boolean isNextToOpponentChip(TypeOfChip turnUser, int i, int j) {
        boolean possiblePutChip = false;
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (k == i && l == j) {
                    continue;
                }
                if (Coordinates.existCoordinates(k, l)) {
                    possiblePutChip = possiblePutChip || (table[k][l].getInsideOfCell() == turnUser.getOpponent());
                }
            }
        }
        return possiblePutChip;
    }

    private boolean isClosed(TypeOfChip turnUser, int i, int j) {
        boolean possiblePutChip = false;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0) {
                    continue;
                }
                if (isClosedByVector(turnUser, i, j, k, l)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isClosedByVector(TypeOfChip turnUser, int i, int j, int shifti, int shiftj) {
        i += shifti;
        j += shiftj;
        if (!Coordinates.existCoordinates(i, j)) {
            return false;
        }
        if (table[i][j].getInsideOfCell() != turnUser.getOpponent()) {
            return false;
        }
        while (true) {
            i += shifti;
            j += shiftj;
            if (!Coordinates.existCoordinates(i, j)) {
                return false;
            }
            if (table[i][j].getInsideOfCell() == TypeOfChip.EMPTY) {
                return false;
            }
            if (table[i][j].getInsideOfCell() == turnUser) {
                return true;
            }
        }
    }

    public void updatePossibilityBoard(TypeOfChip turnUser) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                updatePossibilityCell(turnUser, i, j);
            }
        }
    }

    public boolean isPossiblePutChip(TypeOfChip turnUser, int i, int j) {
        return table[i][j].getPossiblePutChip(turnUser);
    }

    public void putChip(TypeOfChip turnUser, int i, int j) {
        table[i][j].setInsideOfCell(turnUser);
        changeClosedChips(turnUser,i, j);
    }

    private void changeChip(int i, int j) {
        table[i][j].changeChip();
    }

    private void changeClosedChips(TypeOfChip turnUser, int i, int j) {
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0) {
                    continue;
                }
                if (isClosedByVector(turnUser, i, j, k, l)) {
                    changeClosedChipsByVector(turnUser, i, j, k, l);
                }
            }
        }
    }

    private void changeClosedChipsByVector(TypeOfChip turnUser, int i, int j, int shifti, int shiftj) {
        i += shifti;
        j += shiftj;
        while (table[i][j].getInsideOfCell() != turnUser) {
            table[i][j].changeChip();
            i += shifti;
            j += shiftj;
        }
    }

    public ArrayList<Coordinates> getCellsPossiblePutChips(TypeOfChip turnUser){
        ArrayList<Coordinates> cellsPossiblePutChips = new ArrayList<Coordinates>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(table[i][j].getPossiblePutChip(turnUser)){
                    cellsPossiblePutChips.add(new Coordinates(i,j));
                }
            }
        }
        return cellsPossiblePutChips;
    }

}




