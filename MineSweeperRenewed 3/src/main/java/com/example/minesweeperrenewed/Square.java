package com.example.minesweeperrenewed;

public class Square {
    private boolean isBomb;
    private boolean revealed;
    private boolean flagged;
    private int numBombsAround;

    public Square() {
        this.isBomb = false;
        this.revealed = false;
        this.flagged = false;
        this.numBombsAround = 0;
    }

    public boolean getIsBomb() {
        return isBomb;
    }

    public void updateIsBomb(boolean isBomb) {
        this.isBomb = isBomb;
    }

    public boolean getRevealed() {
        return revealed;
    }

    public void updateRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean getFlagged() {
        return flagged;
    }

    public void updateFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getNumBombsAround() {
        return numBombsAround;
    }

    public void updateNumBombsAround(int numBombsAround) {
        this.numBombsAround = numBombsAround;
    }
}
