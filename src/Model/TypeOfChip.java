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

    public TypeOfChip getOpponent(){
        if(this == CHIP_BLACK){
            return CHIP_WHITE;
        }
        if(this == CHIP_WHITE){
            return CHIP_BLACK;
        }
        throw new RuntimeException("Неправильный цвет игрока");
    }
}