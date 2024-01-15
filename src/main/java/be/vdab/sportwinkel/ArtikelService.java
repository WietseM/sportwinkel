package be.vdab.sportwinkel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
class ArtikelService {
    private final ArtikelRepository artikelRepository;
    private final ArtikelGemaaktRepository artikelGemaaktRepository;

    public ArtikelService(ArtikelRepository artikelRepository, ArtikelGemaaktRepository artikelGemaaktRepository) {
        this.artikelRepository = artikelRepository;
        this.artikelGemaaktRepository = artikelGemaaktRepository;
    }

    @Transactional
    public void create(NieuwArtikel nieuwArtikel){
        var artikel = new Artikel(nieuwArtikel);
        artikelRepository.save(artikel);
        artikelGemaaktRepository.save(new ArtikelGemaakt(artikel));
    }
}
