package pl.gorecki.slawomir.library_for_academy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class BookReader {
    private Scanner sc = new Scanner(System.in);;

    public void close() {
        sc.close();
    }
    public int getInt() {
        int number = sc.nextInt();
        return number;
    }
    public double getDouble() {
        double number = sc.nextDouble();
        sc.nextLine();
        return number;
    }
    public String getString() {
         sc.nextLine();
        String name =  sc.nextLine();
        return name;
    }

    public Book[] readBooks() throws FileNotFoundException {
        Book[] offers = new Book[10];
        try (Scanner scanner = new Scanner(new File("Library.csv"))) {
            scanner.nextLine();
            int count=0;
            while(scanner.hasNextLine()){
                offers[count] = createBook(scanner.nextLine());
                count++;
            }
        }
        return offers;
    }
    public void findBookByAuthor(String bookAuthor)  {

        boolean bookFound=false;
        try {
            Book[] books = readBooks();
            for (Book book : books) {
                if(book.getAuthor().equalsIgnoreCase(bookAuthor)) {
                    System.out.println(book);
                    bookFound=true;
                }
            }
            if (!bookFound){
                System.out.println("Nie odnaleziono książki spełniającej wymagania");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }
    public void findBookByTittle(String bookTittle)  {
        boolean bookFound=false;
        try {
            Book[] books = readBooks();
            for (Book book : books) {
                if(book.getTitle().equalsIgnoreCase(bookTittle)) {
                    System.out.println(book);
                    bookFound=true;
                }
            }
            if (!bookFound){
                System.out.println("Nie odnaleziono książki spełniającej wymagania");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }
    public void setStars(String bookTittle, Double stars)  {
        boolean bookFound=false;
        while (stars<1||stars>5){
            System.out.println("podaj liczbę gwiazdek z zakresu od 1 do 5");
            stars=getDouble();
        }
        try {
            Book[] books = readBooks();
            for (Book book : books) {
                if(book.getTitle().equalsIgnoreCase(bookTittle)) {
                    book.setStars(stars);
                    bookFound=true;
                    System.out.println("Książka została pomyślnie oceniona!");
                }
            }
            if (!bookFound){
                System.out.println("Nie odnaleziono książki spełniającej wymagania");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }
    public void findBookByYear(int publicationYear)  {

        boolean bookFound=false;
        try {
            Book[] books = readBooks();
            for (Book book : books) {
                if(book.getYear() == publicationYear) {
                    System.out.println(book);
                    bookFound=true;
                }
            }
            if (!bookFound){
                System.out.println("Nie odnaleziono książki spełniającej wymagania");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }
    public void findBookByPublisher(String publisherName)  {

        boolean bookFound=false;
        try {
            Book[] books = readBooks();
            for (Book book : books) {
                if(book.getPublisher().equalsIgnoreCase(publisherName)) {
                    System.out.println(book);
                    bookFound=true;
                }
            }
            if (!bookFound){
                System.out.println("Nie odnaleziono książki spełniającej wymagania");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }
    public void findBookByStars(double stars)  {

        boolean bookFound=false;
        try {
            Book[] books = readBooks();
            for (Book book : books) {
                if(book.getStars()== stars) {
                    System.out.println(book);
                    bookFound=true;
                }
            }
            if (!bookFound){
                System.out.println("Nie odnaleziono książki spełniającej wymagania");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }


    public void printBooks(){
        try {
            Book[] books = readBooks();
            Arrays.sort(books);
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku offers.csv");
        }
    }


    private static Book createBook(String line) {
        String[] data = line.split(";");
        return new Book(data[0], data[1], Integer.parseInt(data[2]),data[3],Integer.parseInt(data[4]),data[5], Double.parseDouble(data[6]));
    }
}