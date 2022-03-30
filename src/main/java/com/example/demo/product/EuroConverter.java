package com.example.demo.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EuroConverter {

    @JsonProperty("Broj tečajnice")
    private String brojTecajnice;
    @JsonProperty("Datum primjene")
    private String datumPrimjene;
    @JsonProperty("Država")
    private String drzava;
    @JsonProperty("Šifra valute")
    private String sifraValute;
    @JsonProperty("Valuta")
    private String valuta;
    @JsonProperty("Jedinica")
    private String Jedinica;


    public String getBrojTecajnice() {
        return brojTecajnice;
    }

    public void setBrojTecajnice(String brojTecajnice) {
        this.brojTecajnice = brojTecajnice;
    }

    public String getDatumPrimjene() {
        return datumPrimjene;
    }

    public void setDatumPrimjene(String datumPrimjene) {
        this.datumPrimjene = datumPrimjene;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getSifraValute() {
        return sifraValute;
    }

    public void setSifraValute(String sifraValute) {
        this.sifraValute = sifraValute;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getJedinica() {
        return Jedinica;
    }

    public void setJedinica(String jedinica) {
        Jedinica = jedinica;
    }

    public String getKupovniZaDevize() {
        return kupovniZaDevize;
    }

    public void setKupovniZaDevize(String kupovniZaDevize) {
        this.kupovniZaDevize = kupovniZaDevize;
    }

    public String getSrednjiZaDevize() {
        return srednjiZaDevize;
    }

    public void setSrednjiZaDevize(String srednjiZaDevize) {
        this.srednjiZaDevize = srednjiZaDevize;
    }

    public String getProdajniZaDevize() {
        return prodajniZaDevize;
    }

    public void setProdajniZaDevize(String prodajniZaDevize) {
        this.prodajniZaDevize = prodajniZaDevize;
    }
    @JsonProperty("Kupovni za devize")
    private String kupovniZaDevize;
    @JsonProperty("Srednji za devize")
    private String srednjiZaDevize;
    @JsonProperty("Prodajni za devize")
    private String prodajniZaDevize;
}
