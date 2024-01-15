package be.vdab.sportwinkel;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("artikels")
class ArtikelController {
    private final ArtikelService artikelService;


    public ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid NieuwArtikel nieuwArtikel){
        artikelService.create(nieuwArtikel);
    }
}
