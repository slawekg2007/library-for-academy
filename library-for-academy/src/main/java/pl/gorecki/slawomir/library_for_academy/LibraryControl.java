package pl.gorecki.slawomir.library_for_academy;

public class LibraryControl {

    private BookReader bookReader = new BookReader();
    int option;
    public void controlLoop() {


        do {
            printOptions();
            option = bookReader.getInt();
            switch (option) {
                case 1 -> printBooks();
                case 2 -> findBook();
                case 3 -> setStars();
                case 0 -> exit();
                default->System.out.println("Nie ma takiej opcji, wprowadź ponownie: ");
            }
        } while (option != 0);
    }

    private void findBook() {
        do {
            printFindingOptions();
            option = bookReader.getInt();
            switch (option) {
                case 1 -> findBookByTittle();
                case 2 -> findBookByAuthor();
                case 3 -> findBookByYear();
                case 4 -> findBookByPublisher();
                case 5 -> findBookByStars();
                case 6 -> back();
                case 0->exit();
                default->System.out.println("Nie ma takiej opcji, wprowadź ponownie: ");
            }
        } while (option != 0);
    }

    private void setStars() {
        System.out.println("Podaj tytuł książki");
        String name=bookReader.getString();
        System.out.println("Podaj liczbę gwiazdek");
        Double stars=bookReader.getDouble();
        bookReader.setStars(name, stars);
    }

    private void back() {
        controlLoop();
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println(0 + " - Wyjście z programu");
        System.out.println(1 + " - Wyświetl dostępne książki");
        System.out.println(2 + " - Znajdź książkę");
        System.out.println(3 + " - Oceń książkę");

    }
    private void printFindingOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println(0 + " - Wyjście z programu");
        System.out.println(1 + " - Znajdź książkę po tytule");
        System.out.println(2 + " - Znajdź książkę po autorze");
        System.out.println(3 + " - Znajdź książkę po roku publikacji");
        System.out.println(4 + " - Znajdź książkę po wydawnictwie");
        System.out.println(5 + " - Znajdź książkę po ilości gwiazdek");
        System.out.println(6 + " - Powrót do poprzeniego menu");
    }

    private void printBooks() {
        bookReader.printBooks();
    }
    void findBookByYear(){
        System.out.println("Wpisz szukany rok: ");

        bookReader.findBookByYear(bookReader.getInt());
    }
    void findBookByTittle(){
        System.out.println("Wpisz szukany tytuł: ");
        bookReader.findBookByTittle(bookReader.getString());
    }
    void findBookByAuthor(){
        System.out.println("Wpisz szukanego autora");

        bookReader.findBookByAuthor(bookReader.getString());
    }
    void findBookByPublisher(){
        System.out.println("Wpisz szukane wydawnictwo");

        bookReader.findBookByPublisher(bookReader.getString());
    }
    void findBookByStars(){
        System.out.println("Wpisz szukaną ilość gwiazdek");
        bookReader.findBookByStars(bookReader.getDouble());
    }
    private void exit() {
        System.out.println("Koniec programu, papa!");
        bookReader.close();
    }
}


