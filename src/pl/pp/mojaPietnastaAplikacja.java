package pl.pp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mojaPietnastaAplikacja {
    private List<Pojazd> pojazdy;
    private List<Wypozyczenie> wypozyczenia;
    private Scanner scanner;

    public mojaPietnastaAplikacja() {
        pojazdy = new ArrayList<>();
        wypozyczenia = new ArrayList<>();
        scanner = new Scanner(System.in);
        inicjalizujPojazdy();
    }

    private void inicjalizujPojazdy() {
        // Dodajemy przykładowe pojazdy
        pojazdy.add(new Rower("R001", "Trek Mountain", "Czerwony", 15.0, 1200, 21, new Mechaniczny()));
        pojazdy.add(new Rower("R002", "Giant E-Bike", "Niebieski", 25.0, 800, 7, new Elektryczny(85)));
        pojazdy.add(new Hulajnoga("H001", "Xiaomi Mi", "Czarna", 10.0, 450, true, new Elektryczny(70)));
        pojazdy.add(new Hulajnoga("H002", "Razor Classic", "Biała", 8.0, 200, true, new Mechaniczny()));
        pojazdy.add(new Rower("R003", "BMX Sport", "Zielony", 12.0, 300, 1, new Mechaniczny()));
    }

    public void uruchom() {
        System.out.println("=== System Wypożyczalni Rowerów i Hulajnóg ===");

        while (true) {
            wyswietlMenu();
            int wybor = scanner.nextInt();
            scanner.nextLine(); // czyszczenie bufora

            switch (wybor) {
                case 1:
                    wyswietlDostepnePojazdy();
                    break;
                case 2:
                    wypozyczPojazd();
                    break;
                case 3:
                    zwrocPojazd();
                    break;
                case 4:
                    wyswietlAktywneWypozyczenia();
                    break;
                case 5:
                    System.out.println("Dziękujemy za skorzystanie z systemu!");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór!");
            }
        }
    }

    private void wyswietlMenu() {
        System.out.println("\\n--- MENU ---");
        System.out.println("1. Wyświetl dostępne pojazdy");
        System.out.println("2. Wypożycz pojazd");
        System.out.println("3. Zwróć pojazd");
        System.out.println("4. Wyświetl aktywne wypożyczenia");
        System.out.println("5. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    private void wyswietlDostepnePojazdy() {
        System.out.println("\\n--- DOSTĘPNE POJAZDY ---");
        for (Pojazd pojazd : pojazdy) {
            if (pojazd.isDostepny()) {
                String typ = pojazd instanceof Rower ? "Rower" : "Hulajnoga";
                String zasilanie = "";
                int zasieg = 0;

                if (pojazd instanceof Rower) {
                    Rower rower = (Rower) pojazd;
                    zasilanie = rower.getTypZasilania();
                    zasieg = rower.getMaxZasieg();
                } else if (pojazd instanceof Hulajnoga) {
                    Hulajnoga hulajnoga = (Hulajnoga) pojazd;
                    zasilanie = hulajnoga.getTypZasilania();
                    zasieg = hulajnoga.getMaxZasieg();
                }

                System.out.printf("ID: %s | %s: %s | Kolor: %s | Cena: %.2f zł/h | %s",
                        pojazd.getId(), typ, pojazd.model, pojazd.kolor,
                        pojazd.getCenaZaGodzine(), zasilanie);

                if (zasieg > 0) {
                    System.out.printf(" | Zasięg: %d km", zasieg);
                }
                System.out.println();
            }
        }
    }

    private void wypozyczPojazd() {
        System.out.print("Podaj swoje ID klienta: ");
        String idKlienta = scanner.nextLine();

        System.out.print("Podaj ID pojazdu do wypożyczenia: ");
        String idPojazdu = scanner.nextLine();

        Pojazd pojazd = znajdzPojazd(idPojazdu);
        if (pojazd != null && pojazd.isDostepny()) {
            pojazd.wypozycz();
            Wypozyczenie wypozyczenie = new Wypozyczenie(idKlienta, pojazd);
            wypozyczenia.add(wypozyczenie);
            System.out.println("Wypożyczenie rozpoczęte!");
        } else {
            System.out.println("Pojazd nie jest dostępny lub nie istnieje!");
        }
    }

    private void zwrocPojazd() {
        System.out.print("Podaj swoje ID klienta: ");
        String idKlienta = scanner.nextLine();

        Wypozyczenie wypozyczenie = znajdzAktywneWypozyczenie(idKlienta);
        if (wypozyczenie != null) {
            wypozyczenie.zakonczWypozyczenie();
            double koszt = wypozyczenie.obliczKoszt();
            System.out.printf("Pojazd zwrócony! Koszt wypożyczenia: %.2f zł\\n", koszt);
        } else {
            System.out.println("Nie znaleziono aktywnego wypożyczenia dla tego klienta!");
        }
    }

    private void wyswietlAktywneWypozyczenia() {
        System.out.println("\\n--- AKTYWNE WYPOŻYCZENIA ---");
        for (Wypozyczenie wyp : wypozyczenia) {
            if (wyp.isAktywne()) {
                System.out.printf("Klient: %s | Pojazd: %s | Aktualny koszt: %.2f zł\\n",
                        wyp.getIdKlienta(), wyp.getPojazd().getId(), wyp.obliczKoszt());
            }
        }
    }

    private Pojazd znajdzPojazd(String id) {
        for (Pojazd pojazd : pojazdy) {
            if (pojazd.getId().equals(id)) {
                return pojazd;
            }
        }
        return null;
    }

    private Wypozyczenie znajdzAktywneWypozyczenie(String idKlienta) {
        for (Wypozyczenie wyp : wypozyczenia) {
            if (wyp.isAktywne() && wyp.getIdKlienta().equals(idKlienta)) {
                return wyp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        mojaPietnastaAplikacja system = new mojaPietnastaAplikacja();
        system.uruchom();
    }
}


