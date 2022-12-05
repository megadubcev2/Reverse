package Model;

public enum TypeOfChip{
    CHIP_BLACK,
    CHIP_WHITE,
    EMPTY;

    public String toString() {
        if(this == CHIP_BLACK){
            return "B";
        }
        if(this == CHIP_WHITE){
            return "W";
        }
        return " ";
    }
}