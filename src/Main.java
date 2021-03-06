public class Main {

    private static int[][] grid;
    private static boolean[][][] gridBool;

    public static void main(String[] args) {

        GUI gui = new GUI();
        gridBool = new boolean[9][9][9];
        grid = new int[9][9];

        while (!gui.getWasPressed()) {
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {}
        }

        gui.getGrid(grid);

        // set gridBool to true
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                for(int k = 0; k < 9; gridBool[i][j][k] = true, k++);
            }
        }

        // search for given numbers and fill gridBool
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (grid[i][j] != 0) {
                    setFalse(grid[i][j], i, j);
                }
            }
        }

        while(!isEnd()) {
            checkNumbers();
        }

        print();

    }

    // checks for possible numbers and adds them to grid
    public static void checkNumbers()  {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    int x = 0;
                    for(int l = 0; l < 9; l++) {
                        if(!gridBool[l][i][j]) {
                            x++;
                        }
                    }
                    if(x == 8) {
                        for(int l = 0; l < 9; l++) {
                            if(gridBool[l][i][j]) {
                                grid[i][j] = l+1;
                                setFalse(l+1, i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    // setts every given option false
    public static void setFalse(int gridBoolNumber, int x, int y) {

        for (int i = 0; i < 9; i++) {
            gridBool[gridBoolNumber - 1][i][y] = false;
            gridBool[gridBoolNumber - 1][x][i] = false;
        }

        if (x < 3) {
            if (y < 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i][j] = false, j++);
                }
            } else if (y < 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i][j+3] = false, j++);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i][j+6] = false, j++);
                }
            }
        } else if (x < 6) {
            if (y < 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i+3][j] = false, j++);
                }
            } else if (y < 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i+3][j+3] = false, j++);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i+3][j+6] = false, j++);
                }
            }
        } else {
            if (y < 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i+6][j] = false, j++);
                }
            } else if (y < 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i+6][j+3] = false, j++);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; gridBool[gridBoolNumber - 1][i+6][j+6] = false, j++);
                }
            }
        }

    }

    // checks for correct filling of the grid
    public static boolean isFillingCorrect() {

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int z = j+1; z < 9; z++) {

                    // row
                    if (grid[i][j] == grid[i][z]) {
                        return false;
                    }

                    // column
                    if (grid[j][i] == grid[z][i]) {
                        return false;
                    }

                }
            }
        }

        for(int boxRow = 0; boxRow < 9; boxRow = boxRow + 3) {
            for (int boxColumn = 0; boxColumn < 9; boxColumn = boxColumn + 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = i; k < 3; k++) {
                            for (int l = j + 1; l < 3; l++) {

                                if (grid[boxRow + i][boxColumn + j] == grid[boxRow + k][boxColumn + l]) {
                                    return false;
                                }

                            }
                        }
                    }
                }
            }
        }

        return true;

    }

    // checks for game end
    public static boolean isEnd() {
        int x = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (grid[i][j] != 0) {
                    x++;
                }
            }
        }
        return x == 81;
    }

    public static void print() {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

    }

}

