package pl.pp;


import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class LiczbyLosowe {
    public static void main(String[] args) {
        int[] tablica1 = new int[6];
        int[] tablica2 = new int[6];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Losowanie liczb do pierwszej tablicy
        for (int i = 0; i < 6; i++) {
            int wylosowana;
            do {
                wylosowana = random.nextInt(49) + 1;
            } while (contains(tablica1, wylosowana, i));
            tablica1[i] = wylosowana;
        }

        // Wczytywanie liczb od użytkownika
        System.out.println("Podaj 6 różnych liczb z zakresu 1-49:");
        for (int i = 0; i < 6; i++) {
            int liczba;
            do {
                System.out.print("Podaj liczbę " + (i + 1) + ": ");
                liczba = scanner.nextInt();
                if (liczba < 1 || liczba > 49) {
                    System.out.println("Liczba musi być z zakresu 1-49!");
                    continue;
                }
                if (contains(tablica2, liczba, i)) {
                    System.out.println("Ta liczba już została podana!");
                    continue;
                }
                break;
            } while (true);
            tablica2[i] = liczba;
        }

        // Zliczanie powtórzeń
        int powtorzenia = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablica1[i] == tablica2[j]) {
                    powtorzenia++;
                }
            }
        }

        // Wyświetlanie wyników
        System.out.println("\nWylosowane liczby: " + Arrays.toString(tablica1));
        System.out.println("Twoje liczby: " + Arrays.toString(tablica2));
        System.out.println("Liczba powtórzeń: " + powtorzenia);
    }

    // Metoda sprawdzająca czy liczba już występuje w tablicy
    private static boolean contains(int[] array, int number, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }
}