package pl.gorecki.slawomir.library_for_academy;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private int pages;
    private String publisher;
    private String isbn;
    private double stars;


    public Book(String title, String publisher, int year,  String author, int pages, String isbn, double stars) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.publisher = publisher;
        this.isbn = isbn;
        this.stars = stars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    @Override
    public int compareTo(Book o) {
        return getTitle().compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Tytuł: " + title +
                ", Autor: " + author +
                ", Rok wydania: " + year +
                ", Liczba stron: " + pages +
                ", Wydawnictwo: " + publisher +
                ", Isbn: " + isbn+
                ", Ilość gwiazdek: " + stars ;
    }
}
