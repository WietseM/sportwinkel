package be.vdab.sportwinkel;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "artikels")
class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;

    public Artikel(NieuwArtikel nieuwArtikel) {
        this.naam = nieuwArtikel.naam();
        this.aankoopprijs = nieuwArtikel.aankoopprijs();
        this.verkoopprijs = nieuwArtikel.verkoopprijs();
    }

    protected Artikel() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getAankoopprijs() {
        return aankoopprijs;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }
}
