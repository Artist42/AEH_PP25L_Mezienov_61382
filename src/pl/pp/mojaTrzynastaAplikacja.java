package pl.pp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class mojaTrzynastaAplikacja {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path inputFilePath = null;
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            String inputPathStr = scanner.nextLine();
            inputFilePath = Paths.get(inputPathStr);

            if (Files.exists(inputFilePath) && Files.isRegularFile(inputFilePath)) {
                break; // plik istnieje, wychodzimy z pętli
            } else {
                System.out.println("Plik nie istnieje lub nie jest plikiem. Spróbuj ponownie.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
        String outputPathStr = scanner.nextLine();
        Path outputFilePath = Paths.get(outputPathStr);

        try {
            // Wczytanie całej zawartości pliku do jednej zmiennej String
            String content = Files.readString(inputFilePath);

            // Podział na słowa - rozdzielamy po białych znakach i usuwamy znaki interpunkcyjne
            String[] words = content.toLowerCase().split("\\W+");

            // Liczenie słów i ich wystąpień
            Map<String, Integer> wordCounts = new HashMap<>();
            int totalWords = 0;

            for (String word : words) {
                if (word.isEmpty()) {
                    continue; // pomijamy puste elementy
                }
                totalWords++;
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }

            // Wyświetlenie liczby słów
            System.out.println("Liczba słów w pliku '" + inputFilePath.getFileName() + "' to: " + totalWords);

            // Wyświetlenie liczby wystąpień każdego słowa
            System.out.println("Liczba wystąpień poszczególnych słów:");
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.printf("  %s: %d%n", entry.getKey(), entry.getValue());
            }

            // Zapis do pliku wyjściowego
            try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
                writer.write("Nazwa pliku: " + inputFilePath.getFileName());
                writer.newLine();
                writer.write("Liczba słów: " + totalWords);
                writer.newLine();
                writer.write("Liczba wystąpień poszczególnych słów:");
                writer.newLine();
                for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
            }

            System.out.println("Wynik zapisano do pliku: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas odczytu lub zapisu pliku: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
