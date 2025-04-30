package pl.pp;

public class Magazyn {

    private int nrMagazynu;
    private int dnPrzestrzenMagazynowa;
    private String nazwaWlasciciela;
    private String email;
    private String nrTelefonu;

    private int zajetaPrzestrzen;


    public Magazyn() {
    }

    public Magazyn(int nrMagazynu, int dnPrzestrzenMagazynowa, String nazwaWlasciciela, String email, String nrTelefonu) {
        this.nrMagazynu = nrMagazynu;
        this.dnPrzestrzenMagazynowa = dnPrzestrzenMagazynowa;
        this.nazwaWlasciciela = nazwaWlasciciela;
        this.email = email;
        this.nrTelefonu = nrTelefonu;
        this.zajetaPrzestrzen = 0;
    }


    public void dodajTowar(int ilosc) {
        if (ilosc <= 0) {
            System.out.println("Ilość towaru do dodania musi być większa niż 0.");
            return;
        }
        if (ilosc <= dnPrzestrzenMagazynowa) {
            zajetaPrzestrzen += ilosc;
            dnPrzestrzenMagazynowa -= ilosc;
            System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dnPrzestrzenMagazynowa + " jednostek.");
        } else {
            System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + dnPrzestrzenMagazynowa + " jednostek.");
        }
    }

    public void usunTowar(int ilosc) {
        if (ilosc <= 0) {
            System.out.println("Ilość towaru do usunięcia musi być większa niż 0.");
            return;
        }
        if (ilosc <= zajetaPrzestrzen) {
            zajetaPrzestrzen -= ilosc;
            dnPrzestrzenMagazynowa += ilosc;
            System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dnPrzestrzenMagazynowa + " jednostek.");
        } else {
            System.out.println("Nie można usunąć więcej towaru niż jest w magazynie. Aktualna ilość towaru: " + zajetaPrzestrzen + " jednostek.");
        }
    }

    // Metoda sprawdzająca zajętość magazynu
    public void sprawdzZajetosc() {
        System.out.println("Zajęta przestrzeń magazynowa: " + zajetaPrzestrzen + " jednostek.");
        System.out.println("Dostępna przestrzeń magazynowa: " + dnPrzestrzenMagazynowa + " jednostek.");
    }

    // Metoda aktualizująca dane kontaktowe właściciela
    public void aktualizujKontakt(String nowyEmail, String nowyTelefon) {
        if (nowyEmail == null || nowyEmail.isEmpty() || nowyTelefon == null || nowyTelefon.isEmpty()) {
            System.out.println("Niepoprawne dane kontaktowe. Aktualizacja nie powiodła się.");
            return;
        }
        this.email = nowyEmail;
        this.nrTelefonu = nowyTelefon;
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.println("Nowy email: " + this.email);
        System.out.println("Nowy numer telefonu: " + this.nrTelefonu);
    }

    // Przykładowa metoda main do testowania klasy
    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn(1, 5000, "Jan Kowalski", "jan.kowalski@magazyn.pl", "+48 987 654 321");

        magazyn.dodajTowar(3000);  // Dodano 3000 jednostek towaru
        magazyn.usunTowar(1000);   // Usunięto 1000 jednostek towaru
        magazyn.dodajTowar(2500);  // Próba dodania 2500 jednostek (za dużo)
        magazyn.dodajTowar(1500);  // Dodano 1500 jednostek towaru
        magazyn.sprawdzZajetosc(); // Sprawdzenie zajętości
        magazyn.aktualizujKontakt("owner@magazyn.pl", "+48 123 456 789"); // Aktualizacja kontaktu
    }






    public int getNrMagazynu() {
        return nrMagazynu;
    }

    public void setNrMagazynu(int nrMagazynu) {
        this.nrMagazynu = nrMagazynu;
    }

    public int getDnPrzestrzenMagazynowa() {
        return dnPrzestrzenMagazynowa;
    }

    public void setDnPrzestrzenMagazynowa(int dnPrzestrzenMagazynowa) {
        this.dnPrzestrzenMagazynowa = dnPrzestrzenMagazynowa;
    }

    public String getNazwaWlasciciela() {
        return nazwaWlasciciela;
    }

    public void setNazwaWlasciciela(String nazwaWlasciciela) {
        this.nazwaWlasciciela = nazwaWlasciciela;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public int getZajetaPrzestrzen() {
        return zajetaPrzestrzen;
    }

    public void setZajetaPrzestrzen(int zajetaPrzestrzen) {
        this.zajetaPrzestrzen = zajetaPrzestrzen;
    }
}
