package mk.ukim.finki.songlibraryapplication.service.impl;



import mk.ukim.finki.songlibraryapplication.model.Artist;
import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.exceptions.InvalidArtistIdException;
import mk.ukim.finki.songlibraryapplication.repository.ArtistRepository;
import mk.ukim.finki.songlibraryapplication.repository.SongRepository;
import mk.ukim.finki.songlibraryapplication.service.ArtistService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public List<Artist> listAll() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

//Mi davashe erori bez da koristam songs.stream().map(Song::getId).toList() bidejkji barashe da kreiram
//    nova funkcija findAllById vo SongRepository
    @Override
    public Artist create(String name, String artisticName, LocalDate dateOfBirth, String nationality, List<Song> songs) {
        List<Song> songList = songRepository.findAllById(songs.stream().map(Song::getId).toList());
        Artist artist = new Artist(name, artisticName, dateOfBirth, nationality, songList);
        return artistRepository.save(artist);
    }


    @Override
    public Artist getArtistDetails(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new InvalidArtistIdException(id));
        artist.setSongs(artist.getSongs().stream().sorted((s1, s2) -> s2.getTitle().compareTo(s1.getTitle())).toList());
        return artist;
    }

    @Override
    public List<Artist> getArtistsBornBeforeAndNationality(LocalDate date, String nationality) {
        return artistRepository.findByDateOfBirthBeforeAndNationality(date, nationality);
    }
}

