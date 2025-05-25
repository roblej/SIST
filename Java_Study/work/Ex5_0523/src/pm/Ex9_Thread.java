package pm;

import javax.swing.JPanel;

public class Ex9_Thread extends Thread {
    private Ex9_Frame.Point point; // 떨어지는 원의 위치
    private JPanel panel;

    public Ex9_Thread(Ex9_Frame.Point point, JPanel panel) {
        this.point = point;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (point.y < panel.getHeight() - 40) {
            point.y += 5; // 원이 아래로 이동
            panel.repaint(); // 패널을 다시 그린다
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}