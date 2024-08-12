import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {
    private Grid testGrid;
    private Solver solver;
    @BeforeEach
    public void init() {
        int[][] testGridValues = {
            {0, 7, 0, 8, 4, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9, 0, 2, 0},
            {0, 0, 0, 0, 3, 0, 0, 0, 8},
            {3, 0, 0, 0, 7, 0, 4, 1, 0},
            {1, 5, 0, 0, 0, 0, 0, 6, 0},
            {0, 0, 0, 0, 0, 0, 5, 0, 0},
            {0, 1, 5, 0, 0, 0, 3, 0, 0},
            {0, 0, 0, 0, 1, 3, 0, 0, 0},
            {4, 0, 0, 0, 9, 7, 0, 0, 0}
        };
        testGrid = new Grid(testGridValues);
        solver = new Solver(testGrid);
    }

    @Test
    void solveBoxNumber_numberAlreadySolved() {
        assertEquals(1, solver.solveBoxNumber(1, 1));
    }

    @Test
    void solveBoxNumber_numberSolvable() {
        solver.solveBoxNumber(4, 8);
        System.out.println(solver.getGrid());
        assertEquals(new Cell(8, 1, 1), testGrid.getCell(2, 5));
    }

    @Test
    void solveColNumber_numberAlreadySolved() {
        assertEquals(1, solver.solveColNumber(1, 1));
    }
    @Test
    void solveColNumber_numberSolvable(){
        solver.solveColNumber(1, 6);
        System.out.println(solver.getGrid());
        assertEquals(new Cell(6, 1, 1), testGrid.getCell(7, 1));
    }

    @Test
    void solveRowNumber_numberAlreadySolved() {
        assertEquals(1, solver.solveRowNumber(1, 9));
    }

    @Test
    void solveRowNumber_numberSolvable(){
        solver.solveRowNumber(1, 3);
        System.out.println(solver.getGrid());
        assertEquals(new Cell(3, 1, 1), testGrid.getCell(1, 5));
    }

    @Test
    void solveDigit_solveAll() {
        System.out.println(solver.solveDigit(1));
        System.out.println(solver.getGrid());
        assertTrue(solver.solveDigit(1));
    }

    @Test
    void solveDigit_cantSolveAll(){
        solver.solveDigit(2);
        System.out.println(solver.getGrid());
        assertFalse(solver.solveDigit(2));
    }

    @Test
    void solve() {
        solver.solve();
        System.out.println(solver.getGrid());
        assertTrue(solver.solve());
    }
}