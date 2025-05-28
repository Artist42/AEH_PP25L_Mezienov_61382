package pl.pp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class mojaDwunastaAplikacja {

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
            // Wczytanie wszystkich linii z pliku wejściowego
            long lineCount = Files.lines(inputFilePath).count();

            // Wyświetlenie liczby linii użytkownikowi
            System.out.println("Liczba linii w pliku '" + inputFilePath.getFileName() + "' to: " + lineCount);

            // Zapis do pliku wyjściowego: nazwa pliku i liczba linii
            try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath)) {
                writer.write("Nazwa pliku: " + inputFilePath.getFileName());
                writer.newLine();
                writer.write("Liczba linii: " + lineCount);
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
