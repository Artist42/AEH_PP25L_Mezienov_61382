package pl.pp;

import java.util.Scanner;

public class mojaCzternastaAplikacja {

    public static void main(String[] args) {
        typPaliwa diesel = new Diesel();
        typPaliwa benzyna = new Benzyna();
        typPaliwa elektryk = new Elektryk();

        Osobowe osobowe = new Osobowe("KR12345", "VIN123456789", "Czerwony", 100000, 7.5, 50, 15000, 4, benzyna);
        Ciezarowka ciezarowka = new Ciezarowka("KR54321", "VIN987654321", "Niebieski", 200000, 15.0, 80, 50000, 5000, diesel);
        Motocykl motocykl = new Motocykl("KR11111", "VIN111111111", "Czarny", 30000, 5.0, 20, 8000, true, benzyna);
        SprzetBudowlany sprzet = new SprzetBudowlany("KR22222", "VIN222222222", "Zielony", 150000, 10.0, 60, 20000, 1200, diesel);

        osobowe.prowadz();
        System.out.println("Typ paliwa: " + osobowe.getTypPaliwa());
        osobowe.zatankuj(20);

        ciezarowka.prowadz();
        System.out.println("Typ paliwa: " + ciezarowka.getTypPaliwa());
        ciezarowka.zatankuj(50);

        motocykl.prowadz();
        System.out.println("Typ paliwa: " + motocykl.getTypPaliwa());
        motocykl.zatankuj(10);

        sprzet.prowadz();
        System.out.println("Typ paliwa: " + sprzet.getTypPaliwa());
        sprzet.zatankuj(30);
    }
}

