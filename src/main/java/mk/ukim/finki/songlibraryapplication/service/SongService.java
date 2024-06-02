package mk.ukim.finki.songlibraryapplication.service;


import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Genre;

import java.time.LocalDate;
import java.util.List;


public interface SongService {
    List<Song> listAll();

    Song findById(Long id);

    Song create(String title, int duration, LocalDate releaseDate, Genre genre);



    Song filterLongestSongByArtistAndGenre(Long artistId, Genre genre);

    List<Song> filterTop3SongsByDuration(int minDuration, int maxDuration);
}
