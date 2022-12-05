package Model;

public class Cell {
    private TypeOfChip insideOfCell;

    public void setInsideOfCell(TypeOfChip insideOfCell) {
        this.insideOfCell = insideOfCell;
    }

    public TypeOfChip getInsideOfCell() {
        return insideOfCell;
    }

    private boolean possiblePutBlackChip;
    private boolean possiblePutWhiteChip;

    private void setPossiblePutBlackChip(boolean possiblePutBlackChip) {
        this.possiblePutBlackChip = possiblePutBlackChip;
        possiblePutWhiteChip = false;
    }

    private void setPossiblePutWhiteChip(boolean possiblePutWhiteChip) {
        this.possiblePutWhiteChip = possiblePutWhiteChip;
        possiblePutBlackChip = false;
    }

    public void setPossiblePutChip(TypeOfChip turnUser, boolean possiblePutChip) {
        if (turnUser == TypeOfChip.CHIP_BLACK) {
            setPossiblePutBlackChip(possiblePutChip);
        } else if (turnUser == TypeOfChip.CHIP_WHITE) {
            setPossiblePutWhiteChip(possiblePutChip);
        } else {
            throw new RuntimeException("Неправильный цвет игрока");
        }
    }


    public boolean getPossiblePutChip(TypeOfChip turnUser) {
        if (turnUser == TypeOfChip.CHIP_BLACK) {
            return possiblePutBlackChip;
        }
        if (turnUser == TypeOfChip.CHIP_WHITE) {
            return possiblePutWhiteChip;
        }
        throw new RuntimeException("Неправильный цвет игрока");
    }

    public Cell() {
        insideOfCell = TypeOfChip.EMPTY;
    }

    @Override
    public String toString() {
        if (possiblePutBlackChip || possiblePutWhiteChip) {
            return "×";
        }
        return insideOfCell.toString();
    }
}
