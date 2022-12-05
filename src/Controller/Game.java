package Controller;

import Model.Board;
import View.UserInterface;

public class Game {
    UserInterface userInterface;
    Board board;
    public Game(){
        userInterface = new UserInterface();
        board = new Board();
    }
    public void play(){
        Board board = new Board();
        board.printBoard();
        userInterface.askCoordinates();
    }

}
