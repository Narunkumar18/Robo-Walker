package com.robowalker;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot robot = new Robot(5);

    @org.junit.jupiter.api.Test
    void printCoordinates() {
        assertEquals("Position : 0, 0 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void printCoordinatesFailCase() {
        assertNotEquals("Position : 0, 0 Pen: Down Face: south", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void setValueAtCurrentPosition() {
        robot.setValueAtCurrentPosition();
        assertEquals(1, robot.room[0][0]);
    }

    @org.junit.jupiter.api.Test
    void setValueAtCurrentPositionFail() {
        robot.setValueAtCurrentPosition();
        assertNotEquals(0, robot.room[0][0]);
    }

    @org.junit.jupiter.api.Test
    void move() {
        robot.move(2);
        assertEquals("Position : 0, 2 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveOutOfIndex() {
        robot.move(20);
        assertEquals("Position : 0, 5 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void changePenDown() {
        robot.changePenStatus("down");
        assertEquals("Position : 0, 0 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void changePenUp() {
        robot.changePenStatus("up");
        assertEquals("Position : 0, 0 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateWest() {
        robot.rotate("left");
        assertEquals("Position : 0, 0 Pen: up Face: west", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateEast() {
        robot.rotate("right");
        assertEquals("Position : 0, 0 Pen: up Face: east", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateSouth() {
        robot.rotate("left");
        robot.rotate("left");
        assertEquals("Position : 0, 0 Pen: up Face: south", robot.printCoordinates());
    }
}
