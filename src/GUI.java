import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {

    private JLabel title;
    private JTextField[][] slot;
    private JButton button;
    private boolean wasPressed = false;

    public GUI() {

        setTitle("SudokuSolver");
        setSize(450, 535);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        title = new JLabel();
        title.setBounds(0, 450, 450, 50);
        title.setText("Enter Sudoku");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(Color.BLACK);
        title.setOpaque(true);

        button = new JButton();
        button.setText("Start");
        button.setBounds(355, 5, 90, 40);
        button.addActionListener(e -> wasPressed = true);
        title.add(button);
        getContentPane().add(title);

        slot = new JTextField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                slot[i][j] = new JTextField();
                slot[i][j].setBounds(j * 50, i * 50, 50, 50);
                slot[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                slot[i][j].setBackground(Color.ORANGE);
                slot[i][j].setOpaque(true);
                getContentPane().add(slot[i][j]);
            }
        }

        setVisible(true);

    }

    public void getGrid(int[][] grid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (slot[i][j].getText().equals("")) {
                    grid[i][j] = 0;
                } else {
                    try {
                        grid[i][j] = Integer.parseInt(slot[i][j].getText());
                    } catch (NumberFormatException e) {
                        System.out.println("nenene");
                    }
                }
            }
        }

    }

    public boolean getWasPressed() {
        return wasPressed;
    }

}
