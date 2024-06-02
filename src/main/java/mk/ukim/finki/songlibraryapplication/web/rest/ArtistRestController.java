package mk.ukim.finki.songlibraryapplication.web.rest;


import mk.ukim.finki.songlibraryapplication.model.Artist;
import mk.ukim.finki.songlibraryapplication.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/artists")
public class ArtistRestController {

    private final ArtistService artistService;

    public ArtistRestController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        return artistService.findById(id)
                .map(artist -> new ResponseEntity<>(artist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        Artist createdArtist = artistService.create(artist.getName(), artist.getArtisticName(), artist.getDateOfBirth(), artist.getNationality(), artist.getSongs());
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Artist> getArtistDetails(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.getArtistDetails(id), HttpStatus.OK);
    }

    @GetMapping("/before-1999-macedonian")
    public ResponseEntity<List<Artist>> getArtistsBornBefore1999WithNationalityMacedonian() {
        LocalDate date = LocalDate.of(1999, 1, 1);
        List<Artist> artists = artistService.getArtistsBornBeforeAndNationality(date, "Macedonian");
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}
