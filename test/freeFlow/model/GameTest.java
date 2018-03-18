package freeFlow.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game model;

    @BeforeEach
    void setUp() {
        model = new Game(0, new Player("test"), new Level(5));
        model.startGame();
    }

    @Test
    void testConnections() {

        Level level = model.getLevel();
        level.setSelected(2, 2);
        boolean result = model.isLegalMove(level.getSelectedSpace(), 2, 1);
        assertEquals(true, result);
        model.makeMove(level.getSelectedSpace(), 2, 1);
        assertEquals(true, level.getPlayingField()[2][2].isLocked);
        assertEquals(true, level.getPlayingField()[3][1].isLocked);

    }

    @Test
    void testVerticalMove() {
        // test vertical line OK
        Level level = model.getLevel();
        level.setSelected(0, 0);
        boolean result = model.isLegalMove(level.getSelectedSpace(), 0, 4);
        assertEquals(true, result);
    }

    @Test
    void testHorizontalMove() {
        // test horizontal line OK
        Level level = model.getLevel();
        level.setSelected(0, 0);
        boolean result = model.isLegalMove(level.getSelectedSpace(), 2, 0);
        assertEquals(true, result);
    }

    @Test
    void testDiagonalMove() {
        // test diagonal line NOK
        Level level = model.getLevel();
        level.setSelected(0, 0);
        boolean result = model.isLegalMove(level.getSelectedSpace(), 2, 2);
        assertEquals(false, result);
    }

    @Test
    void testInvalidMove() {
        // test move to other colour
        Level level = model.getLevel();
        level.setSelected(0, 0);
        boolean result = model.isLegalMove(level.getSelectedSpace(), 4, 0);
        assertEquals(false, result);
    }


}