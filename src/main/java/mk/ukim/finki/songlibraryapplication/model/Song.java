package mk.ukim.finki.songlibraryapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Genre;

import java.time.LocalDate;

@Data
@Entity
public class Song {

    public Song() {

    }

    public Song(String title, int duration, LocalDate releaseDate, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int duration;

    private LocalDate releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    private Artist artist;



}