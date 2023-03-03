import javax.swing.*;
import java.awt.*;

public class SnakeGameFrame extends JFrame {
    public SnakeGameFrame(){
        SnakeGamePanel sgp=new SnakeGamePanel();
        this.add(sgp);
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}
