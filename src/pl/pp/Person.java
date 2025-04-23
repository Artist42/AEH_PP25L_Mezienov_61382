package pl.pp;

import java.util.Scanner;

public class Person {
    // pola (atrybuty) klasy określającej obiekt "Person" (jego parametry/cechy)
    public String forename; // pole przechowujące cechę imię
    public String surname; // pole przechowujące cechę nazwisko
    public int age; // pole przechowujące cechę wiek
    public String adres;
    public int rok_urodzenia;


    Scanner scanner = new Scanner(System.in);

    /**
     * Konstruktor domyślny - element inicjalizujący pola obiektu podczas jego tworzenia
     * (jeśli sami nie podamy żadnych parametrów)
     */
    public Person() {

    }

    /**
     * Konstruktor z trzema parametrami, które możemy podać przy jego tworzeniu
     */
    public Person(String initForename, String initSurname, int initAge, String initAdres, int initRokUrodzenia) {
        forename = initForename;
        surname = initSurname;
        age = initAge;
        adres = initAdres;
        rok_urodzenia = initRokUrodzenia;
    }

    // metody klasy określające akcje możliwe do wykonania przez obiekt
    public void hiToAll(){
        System.out.println("Nazywam się " + forename + " " + surname + ". " + "Mam " + age + " lat. " + "Mieszkam za adresem " + adres + ". Jestem " + rok_urodzenia + " roku urodzenia.");
    }

    // przykładowa metoda growOld, która zwiększa dany wiek obiektu o jeden za każdym jej wywołaniem
    public int growOld(){
        System.out.println("How much older should he/she get?");
        int howManyYearsOlder = scanner.nextInt();
        age = age + howManyYearsOlder;
        return age;

    }

    public int beYounger(){
        age = age - 1;
        return age;
    }


    // przykładowa metoda getName zwracająca wartość forename obiektu
    public String getName(){
        return forename;
    }

    // przykładowa metoda setName ustawiająca wartość forename obiektu
    public void setName(String nameToSet){
        forename = nameToSet;
    }

}

