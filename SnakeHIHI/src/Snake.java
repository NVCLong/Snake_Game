import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake{
    List<Point> list;
    int bodypart=6;
    char direction='R';
    int UNIT_SIZE=25;

    public Snake() {
        list= new ArrayList<Point>();
        bodypart=6;
    }
    public void setPointSnake(){
        int j= 0;
        for (int i = 0; i < bodypart; i++) {
            list.add(new Point(j,0));
            j-=25;
        }
    }
    public void checkPoint(){
        for (Point p:list) {
            System.out.println(p.toString());
        }
    }
    public  void draw(Graphics g,int x, int y){
        for (Point p: list) {
            if(p.getX()==0 && p.getY()==0) {
                g.setColor(Color.red);
                g.fillRect(p.getX(), p.getY(), x, y);
            }
            else{
                g.setColor(Color.green);
                g.fillRect(p.getX(), p.getY(), x, y);
            }
        }
    }
//    public void move(){
//        int x=list.get(0).getX();
//        int y= list.get(0).getY();
//        System.out.println(list.size());
//        for (int i = list.size(); i > 0; i--) {
//            list.get(i).setX(i - 1);
//            list.get(i).setY(i - 1);
////            System.out.println(list.get(i).getX());
////            System.out.println(list.get(i).getY());
//        }
//        switch (direction){
//            case 'U':
//                list.get(0).setY(y-UNIT_SIZE);
//                break;
//            case 'D':
//                list.get(0).setY(y+UNIT_SIZE);
//                break;
//            case 'R':
//                list.get(0).setX(x+UNIT_SIZE);
//                System.out.println(list.get(0).getX());
//                break;
//            case 'L':
//                list.get(0).setX(x-UNIT_SIZE);
//                break;
//        }
//    }

}