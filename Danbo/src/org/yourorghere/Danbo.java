package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Danbo implements GLEventListener, MouseListener, MouseMotionListener {
    float x = 0;
    float z = 0;

    public static void main(String[] args) {
        Frame frame = new Frame("Pertemuan 3 - Objek 3 Dimensi");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Danbo());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
// Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }
    private float view_rotx = 20.0f;
    private float view_roty = 30.0f;
    private int oldMouseX;
    private int oldMouseY;

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
// Enable VSync
       
        
        
        
        gl.glClearColor(1f, 1f, 1.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
         
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        x += 5;
// Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
// Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        
        
        
        gl.glTranslatef(0, 0, -15f);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        Objek.kepala(gl);
//        gl.glTranslatef(0, -4, 0);
//        Objek.kaki(gl);
//        gl.glTranslatef(7, 0, 0);
//        Objek.kaki(gl);
//        gl.glTranslatef(0, 0, 7);
//        Objek.kaki(gl);
//        gl.glTranslatef(-7, 0, 0);
//        Objek.kaki(gl);
        gl.glTranslatef(1f, 0.5f, 3f);
        Objek.badan(gl);
        gl.glTranslatef(3f, 0.5f, 1f);
        Objek.tangankanan(gl);
        gl.glTranslatef(-4f, 0f, 0f);
        Objek.tangankiri(gl);
        gl.glTranslatef(2.85f, 0f, 3f);
        Objek.kakikanan(gl);
        gl.glTranslatef(-1.69f, 0f, 0f);
        Objek.kakikiri(gl);
        gl.glTranslatef(0f, 2f, -6.5f);
        gl.glRotatef(90, 1, 0, 0);
        Objek.Mata(gl);
        gl.glTranslatef(1.5f, 0f, 0f);
        Objek.Mata(gl);
       
        
        
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        oldMouseX = e.getX();
        oldMouseY = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Dimension size = e.getComponent().getSize();
        float thetaY = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        float thetaX = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
    }

    public void mouseMoved(MouseEvent e) {
    }
}
