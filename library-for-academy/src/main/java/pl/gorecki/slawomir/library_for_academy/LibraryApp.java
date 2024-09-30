package pl.gorecki.slawomir.library_for_academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class LibraryApp {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);

        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
        // BookReader bookReader = new BookReader();
//        bookReader.findBookByTittle("Żona więźnia");
//        bookReader.findBookByAuthor("Albert Camus");

    }
}
