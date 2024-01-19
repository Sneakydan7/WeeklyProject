package org.example.Classes;

public abstract class CatalogElement {
    private Long codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public CatalogElement(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }


    //GETTERS


    public Long getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    @Override
    public String toString() {
        return
                "codiceISBN=" + codiceISBN +
                        ", titolo='" + titolo + '\'' +
                        ", annoPubblicazione=" + annoPubblicazione +
                        ", numeroPagine=" + numeroPagine +
                        '}';
    }
}
