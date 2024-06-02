package mk.ukim.finki.songlibraryapplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Artist {

    public Artist() {
        this.songs = new ArrayList<>();
    }

    public Artist(String name, String artisticName, LocalDate dateOfBirth, String nationality, List<Song> songs) {
        this.name = name;
        this.artisticName = artisticName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.songs = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String artisticName;

    private LocalDate dateOfBirth;

    private String nationality;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs;

}
