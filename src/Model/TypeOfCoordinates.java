package Model;

public enum TypeOfCoordinates {
    CORNER,
    BOUNDARY,
    USUAL;

    final int len = 8;

    public static TypeOfCoordinates getTypeOfCoordinates(int i, int j) {
        if((i == 0 || i == 7) && (j == 0 || j == 7)){
            return CORNER;
        }
        else if ((i == 0 || i == 7) || (j == 0 || j == 7)){
            return BOUNDARY;
        }
        else{
            return USUAL;
        }
    }
}
