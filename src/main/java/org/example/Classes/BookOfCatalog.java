package org.example.Classes;

public class BookOfCatalog extends CatalogElement {
    private String autore;
    private String genere;

    public BookOfCatalog(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //GETTERS

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }


    @Override
    public String toString() {
        return "Libro|||" +
                "autore:'" + autore + '\'' +
                ", genere:'" + genere + '\'' +
                super.toString();
    }
}
