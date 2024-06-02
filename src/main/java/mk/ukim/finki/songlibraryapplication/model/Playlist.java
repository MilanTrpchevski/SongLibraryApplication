package mk.ukim.finki.songlibraryapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Playlist {

    public Playlist() {
        this.existingSongs = new ArrayList<>();

    }

    public Playlist(String name, LocalDate dateOfCreation, Status status, List<Song> existingSongs) {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.status = status;
        this.existingSongs = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dateOfCreation;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    private List<Song> existingSongs;
}