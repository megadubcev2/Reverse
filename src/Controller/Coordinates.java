package Controller;

public class Coordinates {
    public int i;
    public int j;

    public Coordinates(){}
    public Coordinates(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static boolean existCoordinates(int i, int j) {
        return i >= 0 && i <= 7 && j >= 0 && j <= 7;
    }

    @Override
    public String toString() {
        char[] coord = new char[2];
        coord[0] = (char) ('1' + i);
        coord[1] = (char) ('a' + j);
        return String.valueOf(coord);
    }
}
