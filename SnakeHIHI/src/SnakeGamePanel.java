
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGamePanel extends JPanel implements ActionListener {
    final static int SCREEN_WIDTH=600;
    final static int SCREEN_HEIGHT=600;
    final static int UNIT_SIZE=25;
    char direction;
    boolean running=true;
    int DELAY=50;
    Timer timer;
    Random rd;
    Point p1;
    Snake sn;
    Apple apl;



    public SnakeGamePanel(){
        sn=new Snake();
        apl= new Apple();
        rd= new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        setFocusable(true);
        sn.setPointSnake();
        this.addKeyListener(new MykeyAdapter());
        this.startGame();
    }
    public void startGame(){
        newApple();
        running=true;
        timer= new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public  void draw(Graphics g){
        for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
            g.setColor(Color.white);
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
        }
        g.setColor(Color.red);
        g.fillOval(apl.getX(),apl.getY(),UNIT_SIZE,UNIT_SIZE);
//        sn.setPointSnake();
//        for (Point p: sn.list) {
//            g.setColor(Color.white);
//            g.fillRect(p.getX(),p.getY(),UNIT_SIZE,UNIT_SIZE);
//        }
        sn.draw(g,UNIT_SIZE,UNIT_SIZE);
    }
    public void newApple(){
        apl.setX(rd.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE);
        apl.setY(rd.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE);
    }
    public void move(){
//       System.out.println(sn.list.size());

        for (int i = sn.list.size() -1; i > 0; i--) {
            sn.list.get(i).setX(sn.list.get(i - 1).getX());
            sn.list.get(i).setY(sn.list.get(i - 1).getY());
        }
        System.out.println("new value");
        System.out.println(sn.list.toString());
        if (direction == 'U') {
            sn.list.get(0).setY(sn.list.get(0).getY() - UNIT_SIZE);
        } else if (direction == 'D') {
            sn.list.get(0).setY(sn.list.get(0).getY() + UNIT_SIZE);
            System.out.println(sn.list.get(0).toString());
        } else if (direction == 'R') {
            sn.list.get(0).setX(sn.list.get(0).getX() + UNIT_SIZE);
            System.out.println(sn.list.get(0).toString());
        } else if (direction == 'L') {
            sn.list.get(0).setX(sn.list.get(0).getX() - UNIT_SIZE);
        }

    }
    public void nextApple(){
        if(sn.list.get(0).getX()==apl.getX() && sn.list.get(0).getY()== apl.getY()){
            sn.bodypart++;
            newApple();
        }
    }
    public void checkCollision(){
        // check collision with body
        for (int i = sn.list.size()-1; i >0; i--) {
            if((sn.list.get(0).getX()==sn.list.get(i).getX()) && (sn.list.get(0).getY()==sn.list.get(i).getY())){
                running=true;
            }
        }
        System.out.println(" yahahahha: "+sn.list.get(0).getX());
        if(sn.list.get(0).getX()<0){
            running=false;
        } else if (sn.list.get(0).getX()>WIDTH) {
            running=false;
        } else if (sn.list.get(0).getY()<0) {
            running=false;
        } else if (sn.list.get(0).getY()>HEIGHT) {
            running=false;
        }
        if (!running) timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running==true) {
            nextApple();
            //checkCollision();
            move();
        }
        repaint();
    }
    public class MykeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:

                    direction='L';

                    break;
                case KeyEvent.VK_RIGHT:

                    direction='R';

                    break;
                case KeyEvent.VK_UP:

                    direction='U';

                    break;
                case KeyEvent.VK_DOWN:
                    direction='D';
                    break;
            }

        }

    }

}

