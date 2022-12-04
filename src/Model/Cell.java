package Model;

enum InsideOfCell{
    CHIP_BLACK,
    CHIP_WHITE,
    EMPTY;

    @Override
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

enum TypeOfChip{
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

public class Cell {
    TypeOfChip insideOfCell;

    public void setInsideOfCell(TypeOfChip insideOfCell) {
        this.insideOfCell = insideOfCell;
    }

    public TypeOfChip getInsideOfCell() {
        return insideOfCell;
    }

    boolean possiblePutBlackChip;
    boolean possiblePutWhiteChip;

    public void setPossiblePutBlackChip(boolean possiblePutBlackChip) {
        this.possiblePutBlackChip = possiblePutBlackChip;
        possiblePutWhiteChip = false;
    }

    public void setPossiblePutWhiteChip(boolean possiblePutWhiteChip) {
        this.possiblePutWhiteChip = possiblePutWhiteChip;
        possiblePutBlackChip = false;
    }

    public Cell(){
        insideOfCell = TypeOfChip.EMPTY;
    }

}
