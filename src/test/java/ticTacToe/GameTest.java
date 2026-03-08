package ticTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testInitialCurrentPlayer() {
        assertEquals(Symbol.X, game.getCurrentPlayer().getSymbol());
    }

    @Test
    public void testValidMoveAlternatesPlayers() {
        Cell first = new Cell(0, 0, Symbol.EMPTY);
        int result = game.makeMove(first);
        assertEquals(0, result);
        assertEquals(Symbol.O, game.getCurrentPlayer().getSymbol(), "Turn should switch to second player");
    }

    @Test
    public void testInvalidMoveOutOfBounds() {
        // Cell constructor now guards against negative coordinates, so use a valid
        // cell that falls outside the 3×3 board instead.
        Cell bad = new Cell(3, 0, Symbol.EMPTY);
        assertEquals(-1, game.makeMove(bad));
    }

    @Test
    public void testCellConstructorRejectsNegativeCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 0, Symbol.X));
        assertThrows(IllegalArgumentException.class, () -> new Cell(0, -2, Symbol.O));
        assertThrows(IllegalArgumentException.class, () -> new Cell(-5, -5, Symbol.EMPTY));
    }



    @Test
    public void testCannotPlaceOnOccupiedCell() {
        game.makeMove(new Cell(0, 0, Symbol.EMPTY));
        assertEquals(-1, game.makeMove(new Cell(0, 0, Symbol.EMPTY)));
    }

    @Test
    public void testRowWin() {
        game.makeMove(new Cell(0, 0, Symbol.EMPTY)); // X
        game.makeMove(new Cell(1, 0, Symbol.EMPTY)); // O
        game.makeMove(new Cell(0, 1, Symbol.EMPTY)); // X
        game.makeMove(new Cell(1, 1, Symbol.EMPTY)); // O
        int winner = game.makeMove(new Cell(0, 2, Symbol.EMPTY)); // X completes row
        assertEquals(1, winner);
    }

    @Test
    public void testColumnWin() {
        game = new Game(new Player("A", Symbol.X), new Player("B", Symbol.O), 3);
        game.makeMove(new Cell(0, 0, Symbol.EMPTY)); // X
        game.makeMove(new Cell(0, 1, Symbol.EMPTY)); // O
        game.makeMove(new Cell(1, 0, Symbol.EMPTY)); // X
        game.makeMove(new Cell(0, 2, Symbol.EMPTY)); // O
        int winner = game.makeMove(new Cell(2, 0, Symbol.EMPTY)); // X completes column
        assertEquals(1, winner);
    }

    @Test
    public void testDiagonalWin() {
        game = new Game();
        game.makeMove(new Cell(0, 0, Symbol.EMPTY));
        game.makeMove(new Cell(0, 1, Symbol.EMPTY));
        game.makeMove(new Cell(1, 1, Symbol.EMPTY));
        game.makeMove(new Cell(0, 2, Symbol.EMPTY));
        int winner = game.makeMove(new Cell(2, 2, Symbol.EMPTY));
        assertEquals(1, winner);
    }

    @Test
    public void testAntiDiagonalWin() {
        game = new Game();
        game.makeMove(new Cell(0, 2, Symbol.EMPTY)); // X
        game.makeMove(new Cell(0, 0, Symbol.EMPTY)); // O
        game.makeMove(new Cell(1, 1, Symbol.EMPTY)); // X
        game.makeMove(new Cell(1, 0, Symbol.EMPTY)); // O
        int winner = game.makeMove(new Cell(2, 0, Symbol.EMPTY)); // X completes anti‑diagonal
        assertEquals(1, winner);
    }
}