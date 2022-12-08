package Controller;

import View.MenuInterface;
import View.UserInterface;

public class Menu {
    public Menu() {

    }

    public void begin() {
        Game game;
        while (true) {
            int variant = MenuInterface.askVariant();
            if (variant == 1) {
                game = new Game(true);
                game.play();
            } else if (variant == 2) {
                game = new Game(false);
                game.play();
            } else {
                MenuInterface.printGoodbue();
                break;
            }
        }
    }
}
