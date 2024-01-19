package org.example.Classes;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Catalog {
    private List<CatalogElement> elementi;

    public Catalog() {
        this.elementi = new ArrayList<>();
    }

    public void aggiungiElemento(CatalogElement elemento) {
        elementi.add(elemento);
    }


    public void rimuoviElementoConISBN(Long isbn) {
        Iterator<CatalogElement> iterator = elementi.iterator();

        while (iterator.hasNext()) {
            CatalogElement elemento = iterator.next();
            if (elemento.getCodiceISBN().equals(isbn)) {
                iterator.remove();
                System.out.println("Elemento con ISBN " + isbn + " rimosso con successo.");
                return;
            }
        }

        System.out.println("Elemento con ISBN " + isbn + " non trovato nel catalogo.");

    }

    public Optional<CatalogElement> ricercaIsbn(Long isbn) {
        return elementi.stream().filter(elem -> elem.getCodiceISBN().equals(isbn)).findFirst();
    }

    public List<CatalogElement> ricercaPerAnno(int anno) {
        return elementi.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<CatalogElement> ricercaPerAutore(String autore) {

        return elementi.stream().filter(elem -> elem instanceof BookOfCatalog && ((BookOfCatalog) elem).getAutore().equals(autore)).collect(Collectors.toList());
    }

    public void salvaSuDisco() throws IOException {

        StringBuilder toWrite = new StringBuilder();
        for (CatalogElement elementi : elementi) {
            if (elementi instanceof BookOfCatalog) {
                toWrite.append(elementi.getCodiceISBN()).append("@").append(elementi.getTitolo()).append("@")
                        .append(elementi.getAnnoPubblicazione()).append("@").append(elementi.getNumeroPagine())
                        .append("@").append(((BookOfCatalog) elementi).getAutore()).append("@")
                        .append(((BookOfCatalog) elementi).getGenere()).append("#");

            } else if (elementi instanceof MagazineOfCatalog) {
                toWrite.append(elementi.getCodiceISBN()).append("@").append(elementi.getTitolo()).append("@")
                        .append(elementi.getAnnoPubblicazione()).append("@").append(elementi.getNumeroPagine())
                        .append(((MagazineOfCatalog) elementi).getPeriodicita()).append("#");

            }
            File file = new File("prova.txt");
            FileUtils.writeStringToFile(file, toWrite.toString(), "UTF-8");
        }


    }

    Predicate<BookOfCatalog> isABook = Objects::nonNull;


    public List<CatalogElement> caricaDaDisco() throws IOException {
        File file = new File("prova.txt");

        String fileString = FileUtils.readFileToString(file, "UTF-8");

        List<String> splitElementString = Arrays.asList(fileString.split("#"));

        return splitElementString.stream().map(stringa -> {

            String[] elementString = stringa.split("@");
            if (isABook)

        }).toList();

    }


    public List<CatalogElement> getElementi() {
        return elementi;
    }


    @Override
    public String toString() {
        return "Elementi del Catalogo:" + elementi +
                '}';
    }
}
