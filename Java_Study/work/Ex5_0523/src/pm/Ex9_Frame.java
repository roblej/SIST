package pm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex9_Frame extends JFrame {
    /*
    마우스 클릭시 원 생성, 아래로 떨어짐 구현
    */
    JPanel p;
    // 원의 위치를 저장할 리스트
    java.util.List<Point> points = new java.util.ArrayList<>();
    
    public Ex9_Frame() {
        p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 각 점에 대해 원을 그린다
                g.setColor(Color.orange);
                for (Point point : points) {
                    g.fillOval(point.x, point.y, 20, 20);
                }
            }
        };

        this.add(p);
        setBounds(300, 100, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point newPoint = new Point(e.getX(), e.getY());
                points.add(newPoint);
                Ex9_Thread t1 = new Ex9_Thread(newPoint, p);
                t1.start();
            }
        });
    }

    public static void main(String[] args) {
        new Ex8_Frame();
    }
    
    // 포인트를 저장하기 위한 간단한 클래스
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}