package be.vdab.sportwinkel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artikelsgemaakt")
class ArtikelGemaakt {
    @Id
    private long id;
    private String naam;

    ArtikelGemaakt(Artikel artikel){
        id = artikel.getId();
        naam = artikel.getNaam();
    }

    protected ArtikelGemaakt() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
