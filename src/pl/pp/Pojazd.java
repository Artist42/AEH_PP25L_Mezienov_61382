package pl.pp;



public abstract class Pojazd {
    protected String id;
    protected String model;
    protected String kolor;
    protected double cenaZaGodzine;
    protected boolean dostepny;
    protected double przebieg;

    public Pojazd(String id, String model, String kolor, double cenaZaGodzine, double przebieg) {
        this.id = id;
        this.model = model;
        this.kolor = kolor;
        this.cenaZaGodzine = cenaZaGodzine;
        this.dostepny = true;
        this.przebieg = przebieg;
    }

    public abstract void jazda();

    public void wypozycz() {
        if (dostepny) {
            this.dostepny = false;
            System.out.println("Pojazd " + id + " został wypożyczony.");
        } else {
            System.out.println("Pojazd " + id + " nie jest dostępny.");
        }
    }

    public void zwroc() {
        this.dostepny = true;
        System.out.println("Pojazd " + id + " został zwrócony.");
    }

    public boolean isDostepny() {
        return dostepny;
    }

    public String getId() {
        return id;
    }

    public double getCenaZaGodzine() {
        return cenaZaGodzine;
    }
}

// Interfejs typ zasilania
interface TypZasilania {
    String getTypZasilania();
    int getMaxZasieg();
}

// Implementacje interfejsu TypZasilania
class Mechaniczny implements TypZasilania {
    public String getTypZasilania() {
        return "Mechaniczny";
    }

    public int getMaxZasieg() {
        return 0; // brak ograniczeń
    }
}

class Elektryczny implements TypZasilania {
    private int poziomBaterii;

    public Elektryczny(int poziomBaterii) {
        this.poziomBaterii = poziomBaterii;
    }

    public String getTypZasilania() {
        return "Elektryczny";
    }

    public int getMaxZasieg() {
        return poziomBaterii * 2; // 2km na 1% baterii
    }

    public void naladuj() {
        this.poziomBaterii = 100;
        System.out.println("Bateria naładowana do 100%");
    }
}

// Klasy dziedziczące po Pojazd
class Rower extends Pojazd {
    private int liczbaBiegow;
    private TypZasilania zasilanie;

    public Rower(String id, String model, String kolor, double cenaZaGodzine, double przebieg,
                 int liczbaBiegow, TypZasilania zasilanie) {
        super(id, model, kolor, cenaZaGodzine, przebieg);
        this.liczbaBiegow = liczbaBiegow;
        this.zasilanie = zasilanie;
    }

    public void jazda() {
        System.out.println("Jazda na rowerze " + model);
    }

    public String getTypZasilania() {
        return zasilanie.getTypZasilania();
    }

    public int getMaxZasieg() {
        return zasilanie.getMaxZasieg();
    }
}

class Hulajnoga extends Pojazd {
    private boolean skladana;
    private TypZasilania zasilanie;

    public Hulajnoga(String id, String model, String kolor, double cenaZaGodzine, double przebieg,
                     boolean skladana, TypZasilania zasilanie) {
        super(id, model, kolor, cenaZaGodzine, przebieg);
        this.skladana = skladana;
        this.zasilanie = zasilanie;
    }

    public void jazda() {
        System.out.println("Jazda na hulajnodze " + model);
    }

    public String getTypZasilania() {
        return zasilanie.getTypZasilania();
    }

    public int getMaxZasieg() {
        return zasilanie.getMaxZasieg();
    }
}

// Klasa reprezentująca wypożyczenie
class Wypozyczenie {
    private String idKlienta;
    private Pojazd pojazd;
    private long czasRozpoczecia;
    private long czasZakonczenia;
    private boolean aktywne;

    public Wypozyczenie(String idKlienta, Pojazd pojazd) {
        this.idKlienta = idKlienta;
        this.pojazd = pojazd;
        this.czasRozpoczecia = System.currentTimeMillis();
        this.aktywne = true;
    }

    public void zakonczWypozyczenie() {
        this.czasZakonczenia = System.currentTimeMillis();
        this.aktywne = false;
        pojazd.zwroc();
    }

    public double obliczKoszt() {
        long czasTrwania = (aktywne ? System.currentTimeMillis() : czasZakonczenia) - czasRozpoczecia;
        double godziny = czasTrwania / (1000.0 * 60 * 60); // konwersja na godziny
        return Math.ceil(godziny) * pojazd.getCenaZaGodzine();
    }

    public boolean isAktywne() {
        return aktywne;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public String getIdKlienta() {
        return idKlienta;
    }
}


