package hw;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TestPanel extends JPanel {
	int x=210;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.fillRect(x, 235, 80, 30);
	}
}
