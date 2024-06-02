package mk.ukim.finki.songlibraryapplication.web.rest;


import mk.ukim.finki.songlibraryapplication.model.Playlist;
import mk.ukim.finki.songlibraryapplication.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/playlists")
public class PlaylistRestController {

    private final PlaylistService playlistService;

    public PlaylistRestController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return playlistService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable Long id) {
        return new ResponseEntity<>(playlistService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist createdPlaylist = playlistService.create(playlist.getName(), playlist.getDateOfCreation(), playlist.getStatus(), playlist.getExistingSongs());
        return new ResponseEntity<>(createdPlaylist, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-artist/{artistId}")
    public ResponseEntity<List<Playlist>> getPlaylistsByArtist(@PathVariable Long artistId) {
        List<Playlist> playlists = playlistService.filterSongsByArtistNameAndArtistDateOfBirth(artistId);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/public-max3")
    public ResponseEntity<List<Playlist>> getPublicPlaylistsWithMax3Songs() {
        List<Playlist> playlists = playlistService.findPublicPlaylistsWithMax3Songs();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/total-duration/{playlistId}")
    public ResponseEntity<Integer> calculateTotalDuration(@PathVariable Long playlistId) {
        Integer duration = playlistService.calculateTotalDuration(playlistId);
        return new ResponseEntity<>(duration, HttpStatus.OK);
    }

    @PostMapping("/{playlistId}/add-song/{songId}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        Playlist updatedPlaylist = playlistService.addSongToPlaylist(playlistId, songId);
        return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
    }
}

