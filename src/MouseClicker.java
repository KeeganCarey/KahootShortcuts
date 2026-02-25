import types.Pair;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class MouseClicker implements KeyListener {
    private Robot robot;
    private static JFrame frame;
    private Pair mousePos;
    boolean[] keys;

    public MouseClicker() throws AWTException {
        keys = new boolean[4];
        mousePos = new Pair(500, 500);
        robot = new Robot();
    }

    public static void main(String[] args) throws AWTException {
        MouseClicker mouseClicker = new MouseClicker();
        frame = new JFrame();

        frame.addKeyListener(mouseClicker);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP) {
            keys[0] = true;
            mousePos.setY(200);
            updateMouse(mousePos);
        }
        if (e.getKeyChar() == 'a'|| e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[1] = true;
            mousePos.setX(300);
            updateMouse(mousePos);
        }
        if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[2] = true;
            mousePos.setY(600);
            updateMouse(mousePos);
        }
        if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[3] = true;
            mousePos.setX(1200);
            updateMouse(mousePos);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w'|| e.getKeyCode() == KeyEvent.VK_UP) {
            keys[0] = false;
        }
        if (e.getKeyChar() == 'a'|| e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[1] = false;
        }
        if (e.getKeyChar() == 's'|| e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[2] = false;
        }
        if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[3] = false;
        }
        frame.setState(JFrame.NORMAL);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed
    }

    public void updateMouse(Pair pos) {
        robot.mouseMove(pos.getX(), pos.getY());



        if ((keys[3] || keys[1]) && (keys[2] || keys[0])) {
            frame.setState(JFrame.ICONIFIED);
            //Utils.wait(10);
            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
            Utils.wait(10);
            frame.setState(JFrame.NORMAL);
        }
    }
}

