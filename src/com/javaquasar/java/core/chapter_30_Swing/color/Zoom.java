package com.javaquasar.java.core.chapter_30_Swing.color;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 @see http://stackoverflow.com/questions/3742731
 @see https://sites.google.com/site/drjohnbmatthews/kineticmodel
 */
public class Zoom extends JPanel implements MouseMotionListener, MouseListener {

    private static final int SIZE = 16;
    private static final int S2 = SIZE / 2;
    private static final int SCALE = 36;
    private BufferedImage img = null;
    private Robot robot = null;

    public Zoom() {
        super(true);
        this.setPreferredSize(new Dimension(SIZE * SCALE, SIZE * SCALE));
        img = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace(System.err);
        }
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Point p = e.getPoint();
        int x = p.x * SIZE / getWidth();
        int y = p.y * SIZE / getHeight();
        int c = img.getRGB(x, y);
        this.setToolTipText(x + "," + y + ": "
            + String.format("%08X", c));
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        Rectangle rect = new Rectangle(x - S2, y - S2, SIZE, SIZE);
        img = robot.createScreenCapture(rect);
        repaint();
    }

    private static void create() {
        JFrame f = new JFrame("Click & drag to zoom.");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Zoom zoom = new Zoom();
        f.add(zoom);
        f.pack();
        f.setVisible(true);
        zoom.addMouseMotionListener(zoom);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}