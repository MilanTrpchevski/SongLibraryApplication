package mk.ukim.finki.songlibraryapplication.service.impl;

import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Genre;
import mk.ukim.finki.songlibraryapplication.model.exceptions.InvalidSongIdException;
import mk.ukim.finki.songlibraryapplication.repository.SongRepository;
import mk.ukim.finki.songlibraryapplication.service.SongService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new InvalidSongIdException(id));
    }

    @Override
    public Song create(String title, int duration, LocalDate releaseDate, Genre genre) {
        Song song = new Song(title, duration, releaseDate, genre);
        return songRepository.save(song);
    }




    @Override
    public Song filterLongestSongByArtistAndGenre(Long artistId, Genre genre) {
        return songRepository.findLongestSongByArtistAndGenre(artistId,genre);
    }

    @Override
    public List<Song> filterTop3SongsByDuration(int minDuration, int maxDuration) {
        return songRepository.findTop3SongsByDuration(minDuration, maxDuration);
    }



}
