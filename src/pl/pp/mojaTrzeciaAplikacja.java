package pl.pp;
import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz illosc dni. Lub wartość poniżej 0 żeby wyjść z programu:");
        var days = scanner.nextInt();

        while(days>0) {

            int weeks = days/7;
            int remainingDays = days % 7;
            System.out.println(days + " dni to " + weeks + " tygodnie i " + remainingDays +" dni ");
            System.out.println("Wpisz illosc dni. Lub wartość poniżej 0 żeby wyjść z programu:");
            days = scanner.nextInt();
        }

        System.out.println("No wtedy podaj przynajmniej temperature w skali Celsjusz’a lub -1 zeby wyjsc::");
        var Celsjusz = scanner.nextDouble();

        while(Celsjusz!=-1) {

            double Fahrenheit = 1.8 * Celsjusz + 32.0;
            double Kelwin = Celsjusz + 273.16;
            System.out.printf("Stopni Celsjusz'a %.2f to bedzie %.2f Fahrenheit'ow i %.2f Kelwin'a \n", Celsjusz, Fahrenheit, Kelwin);
         //   System.out.println("Fahrenheit'ow i \n" + Kelwin + " Kelwin'a ";

            System.out.println("Podaj temperature w skali Celsjusz’a lub -1 zeby wyjsc:");
            Celsjusz = scanner.nextDouble();

        }

        System.out.println("No ja tak nie gram, to tak nie dziala. Do widzenia");

        scanner.close();







        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj proszę liczbę większą od 100:");

        //pętla WHILE (https://introcs.cs.princeton.edu/java/11cheatsheet/images/while.png)
        var number1 = scanner.nextDouble();
        while (number1 <= 100) {
            System.out.println("Liczba nie jest większa od 100, podaj jeszcze raz:");
            number1 = scanner.nextDouble();
        }
        System.out.println("Dziękuję! Podałeś liczbę: " + number1);

        //pętla DO..WHILE (https://introcs.cs.princeton.edu/java/11cheatsheet/images/do-while.png)
        double number2;
        do {
            System.out.println("Podaj proszę liczbę większą od 200:");
            number2 = scanner.nextDouble();
        } while (number2 <= 200);
        System.out.println("Dziękuję! Podałeś liczbę: " + number2);

        //pętla FOR (https://introcs.cs.princeton.edu/java/11cheatsheet/images/for.png)
        int wynik = 0;
        for (var i = 1; i <= 10; i++) {
            wynik = wynik + i;
            System.out.println("Przebieg numer " + i + " w pętli for, a zmienna wynik = " + wynik);
        }

        //instrukcje warunkowe IF..ELSE (https://introcs.cs.princeton.edu/java/11cheatsheet/images/if.png)
        System.out.println("Podaj proszę liczbę x: ");
        var x = scanner.nextDouble();
        System.out.println("Podaj proszę liczbę y: ");
        var y = scanner.nextDouble();

        if(x > y){
            System.out.println("x jest większe od y");
        } else if (x < y) {
            System.out.println("x jest mniejsze od y");
        } else {
            System.out.println("x jest równe y");
        }

        //zakończenie programu za pomocą wpisania odpowiedniego klawisza
        while(true)
        {
            System.out.println("Wpisz wartość -1 żeby wyjść z programu");
            var input = scanner.nextDouble();
            if(input == -1){
                System.out.println("Wyjście...");
                break;
            }
        }
        scanner.close();*/
    }

}
