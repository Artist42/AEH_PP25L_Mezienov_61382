package pl.pp;

// Abstrakcyjna klasa Pojazd
public abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected double spalanie;
    protected double poziomPaliwa;
    protected double przebieg;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
    }

    public abstract void prowadz();

    public void zatankuj(double ilosc) {
        this.poziomPaliwa += ilosc;
        System.out.println("Zatankowano " + ilosc + " litrów paliwa.");
    }
}

// Interfejs typPaliwa
interface typPaliwa {
    String getTypPaliwa();
}

// Implementacje interfejsu typPaliwa
class Diesel implements typPaliwa {
    public String getTypPaliwa() {
        return "Diesel";
    }
}

class Benzyna implements typPaliwa {
    public String getTypPaliwa() {
        return "Benzyna";
    }
}

class Elektryk implements typPaliwa {
    public String getTypPaliwa() {
        return "Elektryk";
    }
}

// Klasy dziedziczące po Pojazd
class Osobowe extends Pojazd {
    private int liczbaDrzwi;
    private typPaliwa paliwo;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, int liczbaDrzwi, typPaliwa paliwo) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.liczbaDrzwi = liczbaDrzwi;
        this.paliwo = paliwo;
    }

    public void prowadz() {
        System.out.println("Prowadzenie samochodu osobowego.");
    }

    public String getTypPaliwa() {
        return paliwo.getTypPaliwa();
    }
}

class Ciezarowka extends Pojazd {
    private double ladownosc;
    private typPaliwa paliwo;

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, double ladownosc, typPaliwa paliwo) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.ladownosc = ladownosc;
        this.paliwo = paliwo;
    }

    public void prowadz() {
        System.out.println("Prowadzenie ciężarówki.");
    }

    public String getTypPaliwa() {
        return paliwo.getTypPaliwa();
    }
}

class Motocykl extends Pojazd {
    private boolean posiadaDostawke;
    private typPaliwa paliwo;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, boolean posiadaDostawke, typPaliwa paliwo) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.posiadaDostawke = posiadaDostawke;
        this.paliwo = paliwo;
    }

    public void prowadz() {
        System.out.println("Prowadzenie motocykla.");
    }

    public String getTypPaliwa() {
        return paliwo.getTypPaliwa();
    }
}

class SprzetBudowlany extends Pojazd {
    private double przepracowaneGodziny;
    private typPaliwa paliwo;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, double przepracowaneGodziny, typPaliwa paliwo) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.przepracowaneGodziny = przepracowaneGodziny;
        this.paliwo = paliwo;
    }

    public void prowadz() {
        System.out.println("Prowadzenie sprzętu budowlanego.");
    }

    public String getTypPaliwa() {
        return paliwo.getTypPaliwa();
    }
}

