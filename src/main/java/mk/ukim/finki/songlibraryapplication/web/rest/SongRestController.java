package mk.ukim.finki.songlibraryapplication.web.rest;


import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Genre;
import mk.ukim.finki.songlibraryapplication.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/songs")
public class SongRestController {

    private final SongService songService;

    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        Song createdSong = songService.create(song.getTitle(), song.getDuration(), song.getReleaseDate(), song.getGenre());
        return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
    }

    @GetMapping("/longest/{artistId}/{genre}")
    public ResponseEntity<Song> getLongestSongByArtistAndGenre(@PathVariable Long artistId, @PathVariable Genre genre) {
        Song song = songService.filterLongestSongByArtistAndGenre(artistId, genre);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<Song>> getTop3SongsByDuration(@RequestParam int minDuration, @RequestParam int maxDuration) {
        List<Song> songs = songService.filterTop3SongsByDuration(minDuration, maxDuration);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}
