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

}
