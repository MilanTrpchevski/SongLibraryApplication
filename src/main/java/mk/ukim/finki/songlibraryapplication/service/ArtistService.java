package mk.ukim.finki.songlibraryapplication.service;


import mk.ukim.finki.songlibraryapplication.model.Artist;
import mk.ukim.finki.songlibraryapplication.model.Song;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listAll();
    Optional<Artist> findById(Long id);
    Artist create(String name, String artisticName, LocalDate dateOfBirth, String nationality, List<Song> songs);

    Artist getArtistDetails(Long id);

    List<Artist> getArtistsBornBeforeAndNationality(LocalDate date, String nationality);
}
