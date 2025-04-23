package pl.pp;

public class mojaSiodmaAplikacja {
    public static void main(String[] args) {

        Person person1 = new Person(); // utworzenie obiektu person1 klasy Person z domyślnymi parametrami/cechami
        person1.hiToAll(); // domyślnie pola są puste albo są zerami więc to właśnie powinno się wyświetlić

        person1.forename = "Mateusz";
        person1.surname = "Karmazyn";
        person1.age = 24;
        person1.adres = "Okopowa 3";
        person1.rok_urodzenia = 2005;
        person1.hiToAll(); // teraz powinny się wyświetlić wartości, które przed chwilą wpisaliśmy jako cechy obiektu

        // wiedząc, że mamy konstruktor obiektu, który nie jest pusty, ale przyjmuje pewne cechy to można
        // zainicjalizować obiekt w jednej linijce zamiast wpisywać wartości w każde pole jak wyżej

        Person person2 = new Person("Dariusz", "Walendziak", 42, "Al.Jerosolimskie 22", 1980);
        person2.hiToAll();

        // można teraz wykorzystać metodę growOld() np. jeden raz dla obiektu person1 i trzy razy dla obiektu person2
        person1.growOld();
        for(int i=0; i<3; i++) {
            person2.growOld();
        }
        person1.beYounger();
        for(int i=0; i<3; i++) {
            person2.beYounger();
        }
        // i wyświetlić wiek końcowy, czy wszystko się zgadza?
        person1.hiToAll();
        person2.hiToAll();

        // zamiast odwoływać się do konkretnych pól obiektu można napisać metody, które ustawiają np. zmienną
        // forename albo ją odczytują i skorzystać z tych metod
        System.out.println(person1.getName()); // odczytaj forename z obiektu za pomocą metody (patrz - kod klasy Person)
        person1.setName("Lolo"); // zmień pole forename w obiekcie person1
        System.out.println(person1.getName()); // sprawdź czy forename w obiekcie person1 się zmieniło
        person1.hiToAll();
    }
}