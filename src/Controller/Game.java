package Controller;

import Model.Board;
import Model.TypeOfChip;
import View.UserInterface;

import java.util.ArrayList;

public class Game {
    UserInterface userInterface;
    Board board;

    // кто сейчас ходит
    TypeOfChip turnUser;

    boolean isGameWithBot;

    ArrayList<Coordinates> cellsPossiblePutChips;

    public Game(boolean isGameWithBot) {
        this.isGameWithBot = isGameWithBot;
        userInterface = new UserInterface();
        board = new Board();
        turnUser = TypeOfChip.CHIP_BLACK;
    }

    public ArrayList<Coordinates> getCellsPossiblePutChips() {
        return cellsPossiblePutChips;
    }

    public TypeOfChip getTurnUser() {
        return turnUser;
    }

    public void play() {
        boolean isEnded = false;
        while (!isEnded) {
            isEnded = !step();
            changeTurnUser();
        }
        end();
    }

    // возварщаем false если не можем сделать ход
    private boolean step() {
        Coordinates coordinates;
        board.updatePossibilityBoard(turnUser);
        board.printBoard(!isBotStep());
        cellsPossiblePutChips = board.getCellsPossiblePutChips(turnUser);
        if (cellsPossiblePutChips.size() == 0) {
            return false;
        }

        userInterface.printTurnUser(turnUser);
        if (isBotStep()) {
            coordinates = board.chooseBestStep(turnUser);
            userInterface.countdown();
            userInterface.printStep(coordinates, turnUser);
        } else {
            coordinates = userInterface.askCoordinates(this);
        }
        board.putChip(turnUser, coordinates.i, coordinates.j);

        return true;
    }


    private void end() {
        int numberBlackChips = board.countChipsByColor(TypeOfChip.CHIP_BLACK);
        int numberWhiteChips = board.countChipsByColor(TypeOfChip.CHIP_WHITE);

        if (numberBlackChips > numberWhiteChips) {
            userInterface.printWinner(TypeOfChip.CHIP_BLACK);
        } else if (numberBlackChips < numberWhiteChips) {
            userInterface.printWinner(TypeOfChip.CHIP_WHITE);
        }
        //numberBlackChips == numberWhiteChips
        else {
            userInterface.printWinner(TypeOfChip.EMPTY);
        }

    }

    public boolean isPossiblePutChip(Coordinates coordinates) {
        return board.isPossiblePutChip(turnUser, coordinates.i, coordinates.j);
    }

    private void changeTurnUser() {
        turnUser = turnUser.getOpponent();
    }

    private boolean isBotStep() {
        return isGameWithBot && turnUser == TypeOfChip.CHIP_WHITE;
    }

}
