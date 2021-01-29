/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf4.practica.Presentacio;

import java.util.Scanner;

/**
 *
 * @author leandroparedes
 */
public class Vista {

    private String IdVuelo;
    private String scanPrimerCognom;
    private String scanSegonCognom;

    private Billete billete;

    public Vista(Billete b) {

        this.billete = b;
        scanNom = "";
        scanPrimerCognom = "";
        scanSegonCognom = "";
    }

    public void getDades() {
        boolean sortir = false;

        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Nom?");
            scanNom = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Primer cognom?");
            scanPrimerCognom = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Segon cognom?");
            scanSegonCognom = scanner.nextLine();

            scanner = new Scanner(System.in);
            System.out.println("Dades correctes? (s/n)");
            String s = scanner.nextLine();
            if (s.toUpperCase().equals("S")) {
                sortir = true;
            }

        } while (!sortir);

    }

    public boolean getSortir() {
        boolean ret = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sortir? (s/n)");
        String s = scanner.nextLine();
        if (s.toUpperCase().equals("S")) {
            ret = true;
        }

        return ret;
    }

    public String getScanNom() {
        return scanNom;
    }

    public void setScanNom(String scanNom) {
        this.scanNom = scanNom;
    }

    public String getScanPrimerCognom() {
        return scanPrimerCognom;
    }

    public void setScanPrimerCognom(String scanPrimerCognom) {
        this.scanPrimerCognom = scanPrimerCognom;
    }

    public String getScanSegonCognom() {
        return scanSegonCognom;
    }

    public void setScanSegonCognom(String scanSegonCognom) {
        this.scanSegonCognom = scanSegonCognom;
    }

    public void mostraDades() {
        System.out.println("============================");
        System.out.println("Nom: " + model.getNom());
        System.out.println("Cognom1: " + model.getPrimerCognom());
        System.out.println("Cognom2: " + model.getSegonCognom());
        System.out.println("============================");
    }
}
