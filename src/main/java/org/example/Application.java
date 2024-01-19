package org.example;

import com.github.javafaker.Faker;
import org.example.Classes.BookOfCatalog;
import org.example.Classes.Catalog;
import org.example.Classes.CatalogElement;
import org.example.Classes.MagazineOfCatalog;
import org.example.Utility.Recurrency;
import org.example.Utility.Util;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) throws IOException {

        Faker faker = new Faker(Locale.ITALY);
        Supplier<Long> randomNumber = () -> {
            Random random = new Random();
            return random.nextLong(500, 15000);
        };
        Supplier<BookOfCatalog> generateBook = () -> {
            return new BookOfCatalog(randomNumber.get(), faker.book().title(), faker.number().numberBetween(1500, 2024),
                    faker.number().numberBetween(250, 1000), faker.book().author(), faker.book().genre());
        };
        Supplier<MagazineOfCatalog> generateMagazine = () -> {
            return new MagazineOfCatalog(randomNumber.get(), faker.book().title(), faker.number().numberBetween(1500, 2024),
                    faker.number().numberBetween(50, 100), Util.getRandomEnum(Recurrency.class));


        };


        Catalog catalog = new Catalog();
        BookOfCatalog book1 = new BookOfCatalog(4555L, "Paperino e pipo", 1996, 100, "Paperino", "Horror");
        BookOfCatalog book2 = new BookOfCatalog(2222L, "Paperino e pipo", 1996, 100, "Paperino", "Horror");


        catalog.aggiungiElemento(generateBook.get());
        System.out.println(catalog);
        catalog.aggiungiElemento(generateMagazine.get());
        System.out.println(catalog);
        //Metodo aggiungi funziona
        catalog.aggiungiElemento(book1);
        catalog.aggiungiElemento(book2);
        System.out.println(catalog);

        catalog.rimuoviElementoConISBN(4555L);
        // Metodo rimuovi funziona

        Optional<CatalogElement> foundElementISBN = catalog.ricercaIsbn(2222L);
        System.out.println("Ricerca per codice ISBN" + foundElementISBN);
        //Metodo trova per ISBN funziona

        List<CatalogElement> foundElementsByYear = catalog.ricercaPerAnno(1996);
        System.out.println("Ricerca per anno di pubblicazione:" + foundElementsByYear);
        //Metodo trova per anno pubblicazione funziona
        List<CatalogElement> foundElementsByAuthor = catalog.ricercaPerAutore("Paperino");
        System.out.println("Ricerca per autore :" + foundElementsByAuthor);

        catalog.salvaSuDisco();
    }
}