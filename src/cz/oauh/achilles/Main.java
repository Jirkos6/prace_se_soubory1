package cz.oauh.achilles;

import java.io.*;
import java.util.*;

public class Main {

    public static final String NAZEV_SOUBORU = "vstup.txt";
    public static final String ODDELOVAC = "#";


    public static void main(String[] args) throws ZakaznikException {

        List<Zakaznik> zakaznik2 = new ArrayList<>();

        zakaznik2.add(new Zakaznik("Jan Nepomucký", 75));
        zakaznik2.add(new Zakaznik("Andrej Sapkowski", 18));


        int lastIndex = zakaznik2.size() - 1;
        zakaznik2.remove(lastIndex);

        for (Zakaznik zakaznik : zakaznik2)System.out.println(zakaznik.getJmeno() +":"+ zakaznik.getPocetProdeju());



        List<String> zakaznik3 = new ArrayList<>();


        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(NAZEV_SOUBORU)))
        ){
            while (scanner.hasNextLine()){
                String prectenyRadek = scanner.nextLine();
                String[] line = prectenyRadek.split(ODDELOVAC);

                zakaznik3.addAll(Arrays.asList(line));

            }
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

        zakaznik3.forEach(System.out::println);


        List<Zakaznik> zakaznik = new ArrayList<>();

        zakaznik.add(new Zakaznik("Petr Žalud", 54));
        zakaznik.add(new Zakaznik("Vojtěch Fišar", 12));

      

        writeToFile(zakaznik, "vystup.txt",":");
    }

    private static void writeToFile(List<Zakaznik> zakaznik, String soubor, String oddelovac) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(soubor)))
        ){
            for (Zakaznik zakaznik1 : zakaznik) {
                writer.println(zakaznik1.getJmeno() + oddelovac + zakaznik1.getPocetProdeju());
            }
        } catch (IOException e){
            throw new RuntimeException("Chyba při zápisu do souboru " + soubor + ": " + e.getLocalizedMessage());
        }
    }


}