package com.example.minesweeperrenewed;

public class SquareNode {
    private Square square;
    private SquareNode previous;
    private SquareNode next;

    public SquareNode(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public SquareNode getPrevious() {
        return previous;
    }

    public void setPrevious(SquareNode previous) {
        this.previous = previous;
    }

    public SquareNode getNext() {
        return next;
    }

    public void setNext(SquareNode next) {
        this.next = next;
    }
}

