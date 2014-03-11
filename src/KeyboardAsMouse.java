import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
public class KeyboardAsMouse {

	Robot robot;
	int x = 50, y = 50;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				new KeyboardAsMouse();
			}
		});

	}

	public KeyboardAsMouse() {
		
		JFrame guiFrame = new JFrame();
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		x = (int) b.getX();
		y = (int) b.getY();

		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}

		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Mouse");
		guiFrame.setSize(50, 50);
		guiFrame.setLocationRelativeTo(null);

		guiFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				x = (int) b.getX();
				y = (int) b.getY();
				switch (key) {
				case KeyEvent.VK_UP:
					robot.mouseMove(x, y - 10);
					y -= 10;
					break;
				case KeyEvent.VK_DOWN:
					robot.mouseMove(x, y + 10);
					y += 10;
					break;
				case KeyEvent.VK_LEFT:
					robot.mouseMove(x - 10, y);
					x -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					robot.mouseMove(x + 10, y);
					x += 10;
					break;

				case KeyEvent.VK_SPACE:
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					break;
				case KeyEvent.VK_CONTROL:
					robot.mousePress(InputEvent.BUTTON3_MASK);
					robot.mouseRelease(InputEvent.BUTTON3_MASK);

					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		guiFrame.setAlwaysOnTop(true);
		guiFrame.setLocationByPlatform(true);
		guiFrame.setVisible(true);
	}
}