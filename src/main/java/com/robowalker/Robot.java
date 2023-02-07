package com.robowalker;

public class Robot {
    int[][] room;
    int currentPositionX, currentPositionY, size;
    String faceDirection, pen;

    Robot(int size) {
        this.room = new int[size][size];
        this.currentPositionX = 0;
        this.currentPositionY = 0;
        this.faceDirection = "north";
        this.pen = "up";
        this.size = size;
    }

    void setValueAtCurrentPosition() {
        this.room[this.currentPositionX][this.currentPositionY] = 1;
    }

    void move(int steps) {
        try {
            if (this.pen == "up") {
                this.setValueAtCurrentPosition();
                for (int i = 0; i < steps; i = i + 1) {
                    switch (this.faceDirection) {
                        case "north":
                            this.currentPositionY = this.currentPositionY + 1;
                            this.setValueAtCurrentPosition();
                            break;
                        case "south":
                            this.currentPositionY = this.currentPositionY - 1;
                            this.setValueAtCurrentPosition();
                            break;
                        case "east":
                            this.currentPositionX = this.currentPositionX + 1;
                            this.setValueAtCurrentPosition();
                            break;

                        case "west":
                            this.currentPositionX = this.currentPositionX - 1;
                            this.setValueAtCurrentPosition();
                            break;
                    }
                }
            } else {
                System.out.println("Make pen up");
            }
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println("moved to edge of room could not go to the size specified due to size constraint");
        }
    }

    void changePenStatus(String status) {
        this.pen = status;
    }

    String printCoordinates() {
        return "Position : " + this.currentPositionX + ", " + this.currentPositionY + " Pen: " + this.pen.toLowerCase() + " Face: " + this.faceDirection.toLowerCase();
    }

    void printMatrix() {
        int[][] rotatedArray = new int[this.size][this.size];
        for (int i = 0; i < this.size; i = i + 1) {
            for (int j = 0; j < this.size; j = j + 1) {
                rotatedArray[i][j] = this.room[j][this.size - i - 1];
            }
        }
        for (int i = 0; i < size; i = i + 1) {
            for (int j = 0; j < size; j = j + 1) {
                if (rotatedArray[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    void rotate(String direction) {
        if (direction == "left") {
            switch (this.faceDirection) {
                case "north":
                    this.faceDirection = "west";
                    break;
                case "south":
                    this.faceDirection = "east";
                    break;
                case "east":
                    this.faceDirection = "north";
                    break;
                case "west":
                    this.faceDirection = "south";
                    break;
            }
        } else {
            switch (this.faceDirection) {
                case "north":
                    this.faceDirection = "east";
                    break;
                case "south":
                    this.faceDirection = "west";
                    break;
                case "east":
                    this.faceDirection = "south";
                    break;
                case "west":
                    this.faceDirection = "north";
                    break;
            }
        }
    }
}

