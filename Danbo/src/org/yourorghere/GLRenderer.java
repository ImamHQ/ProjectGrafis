package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.io.File;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;

public class GLRenderer implements GLEventListener {

    Texture texture, texture1;

    class vector {

        float x;
        float y;
        float z;

        public vector(float startX, float startY, float startZ) {
            x = startX;
            y = startY;
            z = startZ;
        }

        void vectorRotation(vector reference, float angle) {
            vector temp = reference;
            float magnitude = (float) Math.sqrt(Math.pow(temp.x, 2) + Math.pow(temp.y, 2) + Math.pow(temp.z, 2));
            temp.x = temp.x / magnitude;
            temp.y = temp.y / magnitude;
            temp.z = temp.z / magnitude;
            float dot_product = (x * temp.x) + (y * temp.y) + (z * temp.z);
            float cross_product_x = (y * temp.z) - (temp.z * z);
            float cross_product_y = -((x * temp.z) - (z * temp.x));
            float cross_product_z = (x * temp.y) - (y * temp.x);
            float last_factor_rodrigues = (float) (1 - Math.cos(Math.toRadians(angle % 360)));
            x = (float) ((x * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_x * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * x));
            y = (float) ((this.y * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_y * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * y));
            z = (float) ((z * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_z * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * z));
        }
    }
    vector Sumbu_z = new vector(0f, 0f, -1f);//deklarasi awal vektor untuk maju & mundur
    vector Sumbu_x = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan & kiri
    vector Sumbu_y = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun
    float Cx = 0, Cy = 2.5f, Cz = 0;
    float Lx = 0, Ly = 2.5f, Lz = -20f;
    float sudut_x = 0f;
    float sudut_x2 = 0f;
    float sudut_z = 0f;
    float sudut_z2 = 0f;
    float sudut_y = 0f;
    float sudut_y2 = 0f;
    float sudutKakikanan = -20;
    float sudutKakikiri = 20;
    float sudutTangankanan = -20;
    float sudutTangankiri = 20;
    double tmbhSudut1 = 5;
    double tmbhSudut2 = 5;
    double tmbhSudut3 = 5;
    double tmbhSudut4 = 5;
    boolean ori = true, tangankanan,tangankiri,kakikiri,kakikanan = false;

    /*
ini adalah metod untuk melakukan pergerakan.
magnitude adalah besarnya gerakan sedangkan direction digunakan untuk menentukan arah.
gunakan -1 untuk arah berlawanan dengan vektor awal
     */
    private void vectorMovement(vector toMove, float magnitude, float direction) {
        float speedX = toMove.x * magnitude * direction;
        float speedY = toMove.y * magnitude * direction;
        float speedZ = toMove.z * magnitude * direction;
        Cx += speedX;
        Cy += speedY;
        Cz += speedZ;
        Lx += speedX;
        Ly += speedY;
        Lz += speedZ;
    }

    private void cameraRotation(vector reference, double angle) {
        float M = (float) (Math.sqrt(Math.pow(reference.x, 2) + Math.pow(reference.y, 2) + Math.pow(reference.z, 2)));//magnitud
        float Up_x1 = reference.x / M; //melakukan
        float Up_y1 = reference.y / M; //normalisasi
        float Up_z1 = reference.z / M; //vektor patokan
        float VLx = Lx - Cx;
        float VLy = Ly - Cy;
        float VLz = Lz - Cz;
        float dot_product = (VLx * Up_x1) + (VLy * Up_y1) + (VLz * Up_z1);
        float cross_product_x = (Up_y1 * VLz) - (VLy * Up_z1);
        float cross_product_y = -((Up_x1 * VLz) - (Up_z1 * VLx));
        float cross_product_z = (Up_x1 * VLy) - (Up_y1 * VLx);
        float last_factor_rodriques = (float) (1 - Math.cos(Math.toRadians(angle)));
        float Lx1 = (float) ((VLx * Math.cos(Math.toRadians(angle)))
                + (cross_product_x * Math.sin(Math.toRadians(angle)))
                + (dot_product * last_factor_rodriques * VLx));
        float Ly1 = (float) ((VLy * Math.cos(Math.toRadians(angle)))
                + (cross_product_y * Math.sin(Math.toRadians(angle)))
                + (dot_product * last_factor_rodriques * VLy));
        float Lz1 = (float) ((VLz * Math.cos(Math.toRadians(angle)))
                + (cross_product_z * Math.sin(Math.toRadians(angle)))
                + (dot_product * last_factor_rodriques * VLz));
        Lx = Lx1 + Cx;
        Ly = Ly1 + Cy;
        Lz = Lz1 + Cz;
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
// Enable VSync
        gl.setSwapInterval(1);
        try {
            Warna = TextureIO.newTexture(new File("C:\\Users\\HAQI\\Documents\\NetBeansProjects\\RobotC\\src\\org\\yourorghere\\kardus.jpg"), true);
        } catch (Exception e) {
        }
        gl.glClearColor(0f, 0f, 0.0f, 1.0f);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
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
    Texture Warna;

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
// Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
// Reset the current matrix to the "identity"
        gl.glLoadIdentity();
// Move the "drawing cursor" around
        glu.gluLookAt(Cx, Cy, Cz,
                Lx, Ly, Lz,
                Sumbu_y.x, Sumbu_y.y, Sumbu_y.z);

        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glTranslatef(-2.5f, -16.0f, -7.0f);
        Warna.enable();
        Warna.bind();
        Objek.kepala(gl);
        Warna.disable();
        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(1.0f, 0.5f, 3.0f);
        Warna.enable();
        Warna.bind();
        Objek.badan(gl);
        Warna.disable();
        gl.glPopMatrix();
        
        gl.glTranslatef(-0.2f, 0.5f, 3.3f);
        gl.glRotatef(sudutTangankanan, 1.0f, 0.0f, 0.0f);
        Warna.enable();
        Warna.bind();
        Objek.tangankanan(gl);
        Warna.disable();
        gl.glPopMatrix();
        
        gl.glTranslatef(4.1f, 0.5f, 3.3f);
        gl.glRotatef(sudutTangankiri, 1.0f, 0.0f, 0.0f);
        Warna.enable();
        Warna.bind();
        Objek.tangankiri(gl);
        Warna.disable();
        gl.glPopMatrix();
        
        gl.glTranslatef(1.3f, 0.5f, 7.0f);
        gl.glRotatef(sudutKakikanan, 1.0f, 0.0f, 0.0f);
        Warna.enable();
        Warna.bind();
        Objek.kakikanan(gl);
        Warna.disable();
        gl.glPopMatrix();
        
        gl.glTranslatef(2.8f, 0.5f, 7.0f);
        gl.glRotatef(sudutKakikiri, 1.0f, 0.0f, 0.0f);
        Warna.enable();
        Warna.bind();
        Objek.kakikiri(gl);
        Warna.disable();
        gl.glPopMatrix();
        
//        gl.glTranslatef(-1.5f, 1.5f, -6.8f);
//        gl.glRotatef(90, 1, 0, 0);
//        Objek.Mata(gl);
//        gl.glTranslatef(1.5f, 0f, 0f);
//        Objek.Mata(gl);
//        gl.glTranslatef(0.3f, 1.7f, 0f);
//        gl.glRotatef(90, 0, 0, 1);
//        Objek.Mulut(gl);
//        
        
        if(tangankanan){
        sudutTangankanan += tmbhSudut1;//
        if(sudutTangankanan >= 45 || sudutTangankanan <= -45){
            tmbhSudut1 = -tmbhSudut1;
            }
        }
        if(tangankiri){
        sudutTangankiri += tmbhSudut2;//
        if(sudutTangankiri >= 45 || sudutTangankiri <= -45){
            tmbhSudut2 = -tmbhSudut2;
            }
        }
        sudutKakikanan += tmbhSudut3;//
        if(sudutKakikanan >= 30 || sudutKakikanan <= -30){
            tmbhSudut3 = -tmbhSudut3;
        }
        sudutKakikiri += tmbhSudut4;//
        if(sudutKakikiri >= 30 || sudutKakikiri <= -30){
            tmbhSudut4 = -tmbhSudut4;
        }
        gl.glFlush();

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    void Key_Pressed(int keyCode) {
//huruf W
        if (keyCode == 68) {
            vectorMovement(Sumbu_x, 2f, 1f);
        } //huruf S
        else if (keyCode == 65) {
            vectorMovement(Sumbu_x, 2f, -1f);
        } //huruf A
        else if (keyCode == 83) {
            vectorMovement(Sumbu_z, 2f, 1f);
        } //huruf D
        else if (keyCode == 87) {
            vectorMovement(Sumbu_z, 2f, -1f);
        } //panah atas
        else if (keyCode == 38) {
            vectorMovement(Sumbu_y, 2f, 1f);
        } //panah bawah
        else if (keyCode == 40) {
            vectorMovement(Sumbu_y, 2f, -1f);
        }
        else if (keyCode == 48) {
            if (tangankanan) {
                tangankanan = false;
            } else {
                tangankanan = true;
            }
        }
        else if (keyCode == 57) {
            if (tangankiri) {
                tangankiri = false;
            } else {
                tangankiri = true;
            }
        }
        //huruf J
        else if (keyCode == 74) {
            sudut_z += 15f; //sudut terhadap z
            Sumbu_z.vectorRotation(Sumbu_y, sudut_z - sudut_z2); //memutar vector sumbu z terhadap x (target, patokan)
            Sumbu_x.vectorRotation(Sumbu_y, sudut_z - sudut_z2);
            cameraRotation(Sumbu_y, sudut_z - sudut_z2); //look at
            sudut_z2 = sudut_z; //nyimpan sudut akhir
        }//huruf K
        else if (keyCode == 75) {
            sudut_z += -15f; //sudut terhadap z
            Sumbu_z.vectorRotation(Sumbu_x, sudut_z - sudut_z2); //memutar vector sumbu z terhadap x (target, patokan)
            Sumbu_y.vectorRotation(Sumbu_x, sudut_z - sudut_z2);
            cameraRotation(Sumbu_x, sudut_z - sudut_z2); //look at
            sudut_z2 = sudut_z; //nyimpan sudut akhir
        } //huruf I
        else if (keyCode == 73) {
            sudut_z += 15f; //sudut terhadap z
            Sumbu_z.vectorRotation(Sumbu_x, sudut_z - sudut_z2); //memutar vector sumbu z terhadap x (target, patokan)
            Sumbu_y.vectorRotation(Sumbu_x, sudut_z - sudut_z2);
            cameraRotation(Sumbu_x, sudut_z - sudut_z2); //look at
            sudut_z2 = sudut_z; //nyimpan sudut akhir
        } //huruf L
        else if (keyCode == 76) {
            sudut_z += -15f; //sudut terhadap z
            Sumbu_z.vectorRotation(Sumbu_y, sudut_z - sudut_z2); //memutar vector sumbu z terhadap x (target, patokan)
            Sumbu_x.vectorRotation(Sumbu_y, sudut_z - sudut_z2);
            cameraRotation(Sumbu_y, sudut_z - sudut_z2); //look at
            sudut_z2 = sudut_z; //nyimpan sudut akhir
        }//huruf O
        else if (keyCode == 79) {
            sudut_z += 15f; //sudut terhadap z
            Sumbu_z.vectorRotation(Sumbu_x, sudut_z - sudut_z2); //memutar vector sumbu z terhadap x (target, patokan)
            Sumbu_y.vectorRotation(Sumbu_x, sudut_z - sudut_z2);
            cameraRotation(Sumbu_y, sudut_z - sudut_z2); //look at
            sudut_z2 = sudut_z; //nyimpan sudut akhir
        }
    }
}
