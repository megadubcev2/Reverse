package Controller;

public class Coordinates {
    public int i;
    public int j;

    public Coordinates(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static boolean existCoordinates(int i, int j) {
        return i >= 0 && i <= 7 && j >= 0 && j <= 7;
    }

}
