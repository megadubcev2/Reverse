package Model;

public class Cell {
    private TypeOfChip insideOfCell;

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
