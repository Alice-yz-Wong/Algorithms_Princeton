import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class PercolationTest {

    @org.junit.jupiter.api.Test
    void open() {
        Percolation percolation = new Percolation(10);
        percolation.open(1,1);
        assertTrue(percolation.isOpen(1,1));
        assertTrue(percolation.isFull(1,1));
        percolation.open(2,1);
        assertTrue(percolation.isFull(2,1));
        percolation.open(3,1);
        percolation.open(4,1);
        percolation.open(5,1);
        percolation.open(6,1);
        assertTrue(percolation.isFull(6,1));
        percolation.open(7,1);
        percolation.open(8,1);
        percolation.open(9,1);
        assertTrue(percolation.isFull(9,1));
        percolation.open(10,1);
        assertTrue(percolation.isOpen(10,1));
        assertTrue(percolation.percolates());
        assertTrue(percolation.isFull(10,1));

        percolation.open(10,10);
        assertTrue(percolation.isOpen(10,10));

        percolation.open(3,9);
        assertTrue(percolation.isOpen(3,9));
        assertFalse(percolation.isFull(3,9));


        percolation.open(3,10);
        assertTrue(percolation.isOpen(3,10));
        assertFalse(percolation.isFull(3,10));
    }

    @org.junit.jupiter.api.Test
    void isOpen() {
        Percolation percolation = new Percolation(10);
        percolation.open(1,1);
        assertTrue(percolation.isOpen(1,1));
        assertTrue(percolation.isFull(1,1));


        percolation.open(3,9);
        assertTrue(percolation.isOpen(3,9));
        assertFalse(percolation.isFull(3,9));
        assertFalse(percolation.isOpen(2,9));
    }

    @org.junit.jupiter.api.Test
    void isFull() {
    }

    @org.junit.jupiter.api.Test
    void numberOfOpenSites() {
    }

    @org.junit.jupiter.api.Test
    void percolates() {
    }
}