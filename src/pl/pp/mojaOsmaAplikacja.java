package pl.pp;
import pl.pp.Person;

public class mojaOsmaAplikacja {
    public static void main(String[] args) {

        Konto konto1 = new Konto("RichPerson", "235263263563", 1200, "lorenipsum@gmail.com", "3253543453");

        String NazwaWlasciciela = konto1.getNazwaWlasciciela();
        String nrKonta = konto1.getNrKonta();
        double dnSrodki = konto1.getDnSrodki();
        String email = konto1.getEmail();
        String nrTelefonu = konto1.getNrTelefonu();

        System.out.println("Konto uzytkownika " + NazwaWlasciciela + " i numeren konta: " + nrKonta + " ma tyle zl na koncie: " + dnSrodki + ", ma email: " + email + " i numer telefonu " + nrTelefonu);

        System.out.println("Doladuemy na 500 zl ");
        konto1.doladowanie(500);
        konto1.ileZlotych();
        System.out.println("teraz sprobujemy pobrac 10000 zl: ");
        konto1.pobieranie(10000);
        System.out.println("Ok, teraz sprobujemy pobrac 1700 zl: ");
        konto1.pobieranie(1700);
        konto1.ileZlotych();
        System.out.println("\n");



        Person person1 = new Person("Test", "Testowy", 25); //nowy obiekt klasy Person
        person1.hiToAll(); //wywołanie metody hiToAll() z obiektu person1 klasy Person

        person1.growOld(10); //wywołanie metody growOld( z obiektu person1 klasy Person
        person1.hiToAll();

        person1.setForename("ZmienionyTest"); //wywołanie metody tzw. "settera" do zmiany imienia
        person1.hiToAll();

        String personName = person1.getForename(); //wywołanie metody tzw. "gettera" do pobrania imienia
        int personAge = person1.getAge(); //wywołanie metody tzw. "gettera" do pobrania wieku
        System.out.println("Pobrane imię to " + personName + " z wiekiem = " + personAge);

        Circle circle1 = new Circle(1.2); //nowy obiekt klasy Circle
        circle1.getInfo(); //wywołanie metody getInfo() z obiektu circle1 klasy Circle
        circle1.setRadius(2.6); //wywołanie metody tzw. "settera" do zmiany promienia
        circle1.getInfo();

    }
}