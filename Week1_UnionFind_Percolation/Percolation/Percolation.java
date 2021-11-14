import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final int n;
    private final byte[][] grid;
    private int openCount;

    /**
     * creates n-by-n grid, with all sites initially blocked
     *
     * @param n size of grid
     */
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("illegal");
        }
        // Set initial openCount to 0, n to n, initialize new uf
        this.openCount = 0;
        this.n = n;
        this.uf = new WeightedQuickUnionUF(n * n + 1);
        this.grid = new byte[n + 1][n];
    }

    /**
     * Helper method: convert row col to the 2D index in uf
     */
    private int getGridIdx(int row, int col) {
        return (row - 1) * n + col - 1;
    }

    private byte getValueByIdx(int idx) {
        return grid[idx / n][idx % n];
    }

    /**
     * Helper method: test if input is valid
     */
    private void inputValid(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("out of bound");
        }
    }

    /**
     * Helper method for open to deal with surrounding cells
     */
    private void unionByLoc(int row1, int col1, int row2, int col2) {
        if (row2 > 0 && col2 > 0 && row2 <= n && col2 <= n && isOpen(row2,col2)) {
            int root1Idx = uf.find(getGridIdx(row1, col1)), root2Idx = uf.find(getGridIdx(row2, col2));
            uf.union(root1Idx, root2Idx);
            if (getValueByIdx(root1Idx) == 2 || getValueByIdx(root2Idx) == 2) {
                int newRootIdx = uf.find(root1Idx);
                // Set new parent value to 2
                grid[newRootIdx / n][newRootIdx % n] = 2;
            }
        }
    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // Check if already open
        if (isOpen(row, col)) return;
        openCount += 1;
        grid[row - 1][col - 1] = 1;
        if (row == 1) uf.union(getGridIdx(row, col), n * n); // Union with top
        if (row == n) grid[row - 1][col - 1] = 2; // Set value to 2
        unionByLoc(row, col, row, col + 1);
        unionByLoc(row, col, row + 1, col);
        unionByLoc(row, col, row, col - 1);
        unionByLoc(row, col, row - 1, col);
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        inputValid(row, col);
        return this.grid[row - 1][col - 1] > 0;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        inputValid(row, col);
        return isOpen(row, col) && uf.find(getGridIdx(row, col)) == uf.find(n * n);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return getValueByIdx(uf.find(n * n)) == 2;
    }

}