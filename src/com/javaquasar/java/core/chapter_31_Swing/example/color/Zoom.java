package com.javaquasar.java.core.chapter_31_Swing.example.color;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 @see http://stackoverflow.com/questions/3742731
 @see https://sites.google.com/site/drjohnbmatthews/kineticmodel
 */
public class Zoom extends JPanel implements MouseMotionListener, MouseListener {

    //private static final String METAL_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String METAL_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    //private static final String METAL_LOOK_AND_FEEL = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    //private static final String METAL_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    private static final int SIZE = 16;
    private static final int S2 = SIZE / 2;
    private static final int SCALE = 36;
    private BufferedImage img = null;
    private Robot robot = null;

    public Zoom() {
        super(true);

        try {
            String lookAndFeel = METAL_LOOK_AND_FEEL;
            if (METAL_LOOK_AND_FEEL.equals(lookAndFeel)) {
                MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme() {
                    private final ColorUIResource primary1 = new ColorUIResource(0x4d6781);
                    private final ColorUIResource primary2 = new ColorUIResource(0x7a96b0);
                    private final ColorUIResource primary3 = new ColorUIResource(0xc8d4e2);
                    private final ColorUIResource secondary1 = new ColorUIResource(0x000000);
                    private final ColorUIResource secondary2 = new ColorUIResource(0xaaaaaa);
                    private final ColorUIResource secondary3 = new ColorUIResource(0xdfdfdf);

                    @Override
                    protected ColorUIResource getPrimary1() {
                        return this.primary1;
                    }

                    @Override
                    protected ColorUIResource getPrimary2() {
                        return this.primary2;
                    }

                    @Override
                    protected ColorUIResource getPrimary3() {
                        return this.primary3;
                    }

                    @Override
                    protected ColorUIResource getSecondary1() {
                        return this.secondary1;
                    }

                    @Override
                    protected ColorUIResource getSecondary2() {
                        return this.secondary2;
                    }

                    @Override
                    protected ColorUIResource getSecondary3() {
                        return this.secondary3;
                    }
                });

                UIManager.put("swing.boldMetal", Boolean.FALSE);
            }

            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }



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
        String color = String.format("%08X", c);
        this.setToolTipText(x + "," + y + ": " + color);
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
        zoom.addMouseListener(zoom);
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
        if(SwingUtilities.isRightMouseButton(e)) {
            Point p = e.getPoint();
            int x = p.x * SIZE / getWidth();
            int y = p.y * SIZE / getHeight();
            int c = img.getRGB(x, y);
            String color = String.format("%08X", c);
            this.setToolTipText(x + "," + y + ": " + color);
            setClipboard(color);
            Color initialBackground = new Color(c);
            Color col = JColorChooser.showDialog(null, "Choose a Color", initialBackground);
            if (col != null) {
                setClipboard(col.toString());
            }
        }
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

    public void setClipboard(String str) {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}










