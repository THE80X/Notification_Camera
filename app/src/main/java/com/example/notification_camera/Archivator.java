package com.example.notification_camera;

public class Archivator {
    public static String[] PersonName = new String[16];
    public static String[] Personpassword = new String[16];
    static {
        for (int l=0; l<15; l++){
            PersonName[l]="";
            Personpassword[l]="";
        }
    }
}
