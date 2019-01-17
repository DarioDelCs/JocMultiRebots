package com.example.tnb_20.jocrebots;

import android.widget.ImageView;

public class Pelota {

    float velX;
    float velY;

    int id;

    ImageView iv;

    public Pelota(float velX, float velY, int id){
        this.velX = velX;
        this.velY = velY;
        this.id = id;
    }

    public void moveBall(float x, float y) {

    //ENTRE PAREDES
        // Coordenada x
        float novaPosicioX = iv.getX() + x * velX;
        if (iv.getX() > 0) {// Si el moviment és cap a la dreta
            // Comprovem que no surti de les dimensions de la pantalla en assignar la nova posició
            if (novaPosicioX + iv.getWidth() < ActivityMain.width) {
                iv.setX(novaPosicioX);
            } else {// Si en surt, establim la posició màxima en horitzontal perquè es pugui veure la imatge.
                //img.setX(novaPosicioX- img.getWidth());
                iv.setX(ActivityMain.width - iv.getWidth());
                velX=(-1)*velX;
            }
        } else {// Fem el mateix pel moviment cap a l'esquerra
            if (novaPosicioX > 0) {
                iv.setX(novaPosicioX);
            } else{
                iv.setX(0);
                velX=(-1)*velX;
            }
        }

        // Coordenada y
        float novaPosicioY = iv.getY() + y * velY;
        // El concepte és el mateix que a la X
        if (iv.getY() > 0) {
            if (novaPosicioY + iv.getHeight() + ActivityMain.statusBar < ActivityMain.height) {//
                iv.setY(novaPosicioY);
            } else {
                //img.setY(novaPosicioY*-1);
                iv.setY(ActivityMain.height - iv.getHeight() - ActivityMain.statusBar);
                velY=(-1)*velY;
            }
        }else {
            if (novaPosicioY > 0) {
                iv.setY(novaPosicioY);
            } else {
                iv.setY(0);
                velY=(-1)*velY;
            }
        }
    //FIN ENTRE PAREDES

        colision(x, y);
    }

    public void colision(float x, float y){

        for (Pelota pelota : ActivityMain.pelotas) {
            if (pelota.id!=this.id){
                // Coordenada x
                float novaPosicioX = this.iv.getX() + x * velX;
                if (this.iv.getX() < pelota.iv.getX()) {// Si el moviment és cap a la dreta
                    // Comprovem que no surti de les dimensions de la pantalla en assignar la nova posició
                    if (novaPosicioX + this.iv.getWidth() > pelota.iv.getX()+pelota.iv.getWidth()) {
                        this.iv.setX(novaPosicioX);
                    } else {// Si en surt, establim la posició màxima en horitzontal perquè es pugui veure la imatge.
                        //img.setX(novaPosicioX- img.getWidth());
                        this.iv.setX(ActivityMain.width - this.iv.getWidth());
                        velX=(-1)*velX;
                    }
                } else {// Fem el mateix pel moviment cap a l'esquerra
                    if (novaPosicioX < pelota.iv.getX()) {
                        this.iv.setX(novaPosicioX);
                    } else{
                        this.iv.setX(0);
                        velX=(-1)*velX;
                    }
                }

                // Coordenada y
                float novaPosicioY = this.iv.getY() + y * velY;
                // El concepte és el mateix que a la X
                if (this.iv.getY() < pelota.iv.getY()) {
                    if (novaPosicioY + this.iv.getHeight() + ActivityMain.statusBar > pelota.iv.getY()+pelota.iv.getHeight()) {
                        this.iv.setY(novaPosicioY);
                    } else {
                        //img.setY(novaPosicioY*-1);
                        this.iv.setY(ActivityMain.height - this.iv.getHeight() - ActivityMain.statusBar);
                        velY=(-1)*velY;
                    }
                }else {
                    if (novaPosicioY < pelota.iv.getY()) {
                        this.iv.setY(novaPosicioY);
                    } else {
                        this.iv.setY(0);
                        velY=(-1)*velY;
                    }
                }
                /*// Coordenada x
                float novaPosicioX = this.iv.getX() + x * velX;
                if (this.iv.getX() > pelota.iv.getHeight()) {// Si el moviment és cap a la dreta
                    // Comprovem que no surti de les dimensions de la pantalla en assignar la nova posició
                    if (novaPosicioX + this.iv.getWidth() < pelota.iv.getX()) {//Y??
                        this.iv.setX(novaPosicioX);
                    } else {// Si en surt, establim la posició màxima en horitzontal perquè es pugui veure la imatge.
                        //img.setX(novaPosicioX- img.getWidth());
                        this.iv.setX(ActivityMain.width - this.iv.getWidth());
                        velX=(-1)*velX;
                    }
                } else {// Fem el mateix pel moviment cap a l'esquerra
                    if (novaPosicioX > pelota.iv.getHeight()) {
                        this.iv.setX(novaPosicioX);
                    } else{
                        this.iv.setX(0);
                        velX=(-1)*velX;
                    }
                }

                // Coordenada y
                float novaPosicioY = this.iv.getY() + y * velY;
                // El concepte és el mateix que a la X
                if (this.iv.getY() > pelota.iv.getWidth()) {
                    if (novaPosicioY + this.iv.getHeight() + ActivityMain.statusBar < pelota.iv.getY()) {//X
                        this.iv.setY(novaPosicioY);
                    } else {
                        //img.setY(novaPosicioY*-1);
                        this.iv.setY(ActivityMain.height - this.iv.getHeight() - ActivityMain.statusBar);
                        velY=(-1)*velY;
                    }
                }else {
                    if (novaPosicioY > pelota.iv.getWidth()) {
                        this.iv.setY(novaPosicioY);
                    } else {
                        this.iv.setY(0);
                        velY=(-1)*velY;
                    }
                }*/
            }
        }
    }
}
