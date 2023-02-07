package com.robowalker;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot robot = new Robot(5);

    @org.junit.jupiter.api.Test
    void printCoordinates() {
        assertEquals("Position : 0, 0 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void setValueAtCurrentPosition() {
        robot.setValueAtCurrentPosition();
        assertEquals(1, robot.room[0][0]);
    }

    @org.junit.jupiter.api.Test
    void move() {
        robot.move(2);
        assertEquals("Position : 0, 2 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void changePenStatus() {
        robot.changePenStatus("down");
        assertEquals("Position : 0, 0 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotate() {
        robot.rotate("east");
        assertEquals("Position : 0, 0 Pen: up Face: east", robot.printCoordinates());
    }
}