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

    ArrayList<Coordinates> cellsPossiblePutChips;

    public Game() {
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
        Coordinates coordinates;

        while (true) {
            board.updatePossibilityBoard(turnUser);
            board.printBoard();
            cellsPossiblePutChips =  board.getCellsPossiblePutChips(turnUser);
            if(cellsPossiblePutChips.size() == 0){
                userInterface.printGoodbue();
                break;
            }
            coordinates = userInterface.askCoordinates(this);
            board.putChip(turnUser, coordinates.i, coordinates.j);
            changeTurnUser();
        }
    }



    public boolean isPossiblePutChip(Coordinates coordinates) {
        return board.isPossiblePutChip(turnUser, coordinates.i, coordinates.j);
    }

    private void changeTurnUser(){
        turnUser = turnUser.getOpponent();
    }
}
