package pl.pp;
import java.util.Scanner;
public class mojaDrugaAplikacja {
    public static void main(String[] args) {
        int x = 10; //utworzenie zmiennej typu int i przypisanie jej wartości 10

        Scanner scanner = new Scanner(System.in);
        System.out.println("Jak x = 10, to:");
        var result = x*2;
        System.out.println("x*2 = " + result);
        result = x*x;
        System.out.println("x^2 = " + result);

        System.out.println("Wpisz ile mash lat:");
        int first = scanner.nextInt(); //prośba o wpisanie wartości typu double
        System.out.println("Czy wiesz, że przeżyłeś na Ziemi około " + (first * 365 * 24 * 60 * 60) + "sekund");
    }
}





//Kod z wykladu 1:

/*package pl.pp;
public class mojaDrugaAplikacja {
    public static void main(String[] args) {
        System.out.println("Witaj PP!");
    }
}*/
