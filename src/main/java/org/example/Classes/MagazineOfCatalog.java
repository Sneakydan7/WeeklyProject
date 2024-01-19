package org.example.Classes;

import org.example.Utility.Recurrency;

public class MagazineOfCatalog extends CatalogElement {

    private Recurrency periodicita;

    public MagazineOfCatalog(Long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Recurrency periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }


//GETTERS

    public Recurrency getPeriodicita() {
        return periodicita;
    }


    @Override
    public String toString() {
        return "Rivista|||" +
                "periodicita=" + periodicita + " " +
                super.toString();
    }
}
