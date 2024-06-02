package mk.ukim.finki.songlibraryapplication.service;

import mk.ukim.finki.songlibraryapplication.model.Playlist;
import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Status;

import java.time.LocalDate;
import java.util.List;

public interface PlaylistService {
    List<Playlist> listAll();

    Playlist findById(Long id);

    Playlist create(String name, LocalDate dateOfCreation, Status status, List<Song> existingSongs);


    void deleteById(Long id);

    List<Playlist> filterSongsByArtistNameAndArtistDateOfBirth(Long artistId);

    List<Playlist> findPublicPlaylistsWithMax3Songs();

    Integer calculateTotalDuration(Long playlistId);

    Playlist addSongToPlaylist(Long playlistId, Long songId);
}
