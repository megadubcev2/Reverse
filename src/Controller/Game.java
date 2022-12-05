package Controller;

import Model.Board;
import Model.TypeOfChip;
import View.UserInterface;

public class Game {
    UserInterface userInterface;
    Board board;

    // кто сейчас ходит
    TypeOfChip turnUser;

    public Game(){
        userInterface = new UserInterface();
        board = new Board();
        turnUser = TypeOfChip.CHIP_BLACK;

    }
    public void play(){
        board.updatePossibilityBoard(turnUser);
        board.printBoard();
        userInterface.askCoordinates();
    }

    public boolean isPossiblePutChip(){
        return true;
    }
}
