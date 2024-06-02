package mk.ukim.finki.songlibraryapplication.service.impl;

import mk.ukim.finki.songlibraryapplication.model.Playlist;
import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Status;
import mk.ukim.finki.songlibraryapplication.model.exceptions.InvalidPlaylistIdException;
import mk.ukim.finki.songlibraryapplication.repository.PlaylistRepository;
import mk.ukim.finki.songlibraryapplication.repository.SongRepository;
import mk.ukim.finki.songlibraryapplication.service.PlaylistService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public List<Playlist> listAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist findById(Long id) {
        return playlistRepository.findById(id).orElseThrow(() -> new InvalidPlaylistIdException(id));
    }
    //Mi davashe erori bez da koristam songs.stream().map(Song::getId).toList() bidejkji barashe da kreiram
//    nova funkcija findAllById vo SongRepository
    @Override
    public Playlist create(String name, LocalDate dateOfCreation, Status status, List<Song> existingSongs) {
        List<Song> songs = songRepository.findAllById(existingSongs.stream().map(Song::getId).collect(Collectors.toList()));
        Playlist playlist = new Playlist(name, dateOfCreation, status, songs);
        return playlistRepository.save(playlist);
    }

    @Override
    public void deleteById(Long id) {
        this.playlistRepository.deleteById(id);
    }

    @Override
    public List<Playlist> filterSongsByArtistNameAndArtistDateOfBirth(Long artistId) {
        return playlistRepository.filterSongsByArtistNameAndArtistDateOfBirth(artistId);
    }

    @Override
    public List<Playlist> findPublicPlaylistsWithMax3Songs() {
        return playlistRepository.findPublicPlaylistsWithMax3Songs(Status.PUBLIC, 3);
    }

    @Override
    public Integer calculateTotalDuration(Long playlistId) {
        return playlistRepository.calculateTotalDuration(playlistId);
    }

    @Override
    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = findById(playlistId);
        Song song = songRepository.findById(songId).orElseThrow(() -> new RuntimeException("Song not found"));
        playlist.getExistingSongs().add(song);
        return playlistRepository.save(playlist);
    }
}
