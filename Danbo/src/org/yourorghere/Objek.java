/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;

/**
 *
 * @author HAQI
 */
public class Objek {

    static void Mata(GL gl) {

        //warna benda
        float amb[] = {0f,0f,0f,1.0f};
        float diff[] = {0.f,0f,0f,10f};
        float spec[] = {0f,0f,0f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        
        double PI = 3.141592653589793;
        int i, radius, jumlah_titik, x_tengah, y_tengah;
        radius = 25;
        jumlah_titik = 30;
        x_tengah = 50;
        y_tengah = 50;
        gl.glBegin(GL.GL_POLYGON);
        for (i = 0; i < jumlah_titik; i++) {
            float sudut;
            sudut = (float) (i * (2 * PI / jumlah_titik));
            float x = (float) (x_tengah + radius * Math.cos(sudut));
            float y = (float) (y_tengah + radius * Math.sin(sudut));
            gl.glVertex2f(x / 100, y / 100);
        }
        gl.glEnd();
    }

    static void kepala(GL gl) {
        //warna benda
        float amb[] = {1.0f,0.51f,0.0f,1.0f};
        float diff[] = {0.07568f,0.1f,0.07568f,1.0f};
        float spec[] = {0.07568f,0.1f,0.07568f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        gl.glBegin(GL.GL_POLYGON);//kiri
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 3, 0);//2
        gl.glVertex3f(0, 3, 3);//3
        gl.glVertex3f(0, 0, 3);//4
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//atas
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(5, 0, 0);//5
        gl.glVertex3f(5, 3, 0);//6
        gl.glVertex3f(0, 3, 0);//2
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//belakang
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(5, 0, 3);//8
        gl.glVertex3f(5, 0, 0);//5
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//depan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 3, 0);//2
        gl.glVertex3f(5, 3, 0);//6
        gl.glVertex3f(5, 3, 3);//7
        gl.glVertex3f(0, 3, 3);//3
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//kanan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(5, 0, 0);//5
        gl.glVertex3f(5, 3, 0);//6
        gl.glVertex3f(5, 3, 3);//7
        gl.glVertex3f(5, 0, 3);//8
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//bawah
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(5, 3, 3);//7
        gl.glVertex3f(5, 0, 3);//8
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(0, 3, 3);//3
        gl.glEnd();
    }

    static void badan(GL gl) {
        //warna benda
        float amb[] = {1.0f,0.51f,0.0f,1.0f};
        float diff[] = {0.07568f,0.1f,0.07568f,1.0f};
        float spec[] = {0.07568f,0.1f,0.07568f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        gl.glBegin(GL.GL_POLYGON);//kiri
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 2, 0);//2
        gl.glVertex3f(0, 2, 4);//3
        gl.glVertex3f(0, 0, 4);//4
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//atas
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(3, 0, 0);//5
        gl.glVertex3f(3, 2, 0);//6
        gl.glVertex3f(0, 2, 0);//2
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//belakang
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 0, 4);//4
        gl.glVertex3f(3, 0, 4);//8
        gl.glVertex3f(3, 0, 0);//5
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//depan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 2, 0);//2
        gl.glVertex3f(3, 2, 0);//6
        gl.glVertex3f(3, 2, 4);//7
        gl.glVertex3f(0, 2, 4);//3
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//kanan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(3, 0, 0);//5
        gl.glVertex3f(3, 2, 0);//6
        gl.glVertex3f(3, 2, 4);//7
        gl.glVertex3f(3, 0, 4);//8
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//bawah
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(3, 2, 4);//7
        gl.glVertex3f(3, 0, 4);//8
        gl.glVertex3f(0, 0, 4);//4
        gl.glVertex3f(0, 2, 4);//3
        gl.glEnd();
    }

    static void tangankanan(GL gl) {
        //warna benda
        float amb[] = {1.0f,0.51f,0.0f,1.0f};
        float diff[] = {0.07568f,0.1f,0.07568f,1.0f};
        float spec[] = {0.07568f,0.1f,0.07568f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        gl.glBegin(GL.GL_POLYGON);//kiri
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(0, 1, 3);//3
        gl.glVertex3f(0, 0, 3);//4
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//atas
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(0, 1, 0);//2
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//belakang
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(1, 0, 0);//5
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//depan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//kanan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//bawah
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();
    }

    static void tangankiri(GL gl) {
        //warna benda
        float amb[] = {1.0f,0.51f,0.0f,1.0f};
        float diff[] = {0.07568f,0.1f,0.07568f,1.0f};
        float spec[] = {0.07568f,0.1f,0.07568f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        gl.glBegin(GL.GL_POLYGON);//kiri
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(0, 1, 3);//3
        gl.glVertex3f(0, 0, 3);//4
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//atas
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(0, 1, 0);//2
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//belakang
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(1, 0, 0);//5
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//depan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//kanan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//bawah
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();
    }

    static void kakikanan(GL gl) {
        //warna benda
        float amb[] = {1.0f,0.51f,0.0f,1.0f};
        float diff[] = {0.07568f,0.1f,0.07568f,1.0f};
        float spec[] = {0.07568f,0.1f,0.07568f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        gl.glBegin(GL.GL_POLYGON);//kiri
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(0, 1, 3);//3
        gl.glVertex3f(0, 0, 3);//4
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//atas
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(0, 1, 0);//2
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//belakang
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(1, 0, 0);//5
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//depan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//kanan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//bawah
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();
    }

    static void kakikiri(GL gl) {
        //warna benda
        float amb[] = {1.0f,0.51f,0.0f,1.0f};
        float diff[] = {0.07568f,0.1f,0.07568f,1.0f};
        float spec[] = {0.07568f,0.1f,0.07568f,1.0f};
        float shine = 200;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        
        gl.glBegin(GL.GL_POLYGON);//kiri
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(0, 1, 3);//3
        gl.glVertex3f(0, 0, 3);//4
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//atas
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(0, 1, 0);//2
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//belakang
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 0, 0);//1
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(1, 0, 0);//5
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//depan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(0, 1, 0);//2
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//kanan
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 0, 0);//5
        gl.glVertex3f(1, 1, 0);//6
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);//bawah
        gl.glColor3f(0.82f, 0.70f, 0.39f);
        gl.glVertex3f(1, 1, 3);//7
        gl.glVertex3f(1, 0, 3);//8
        gl.glVertex3f(0, 0, 3);//4
        gl.glVertex3f(0, 1, 3);//3
        gl.glEnd();
    }

}
