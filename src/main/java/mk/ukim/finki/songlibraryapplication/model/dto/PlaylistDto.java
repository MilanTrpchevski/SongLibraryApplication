package mk.ukim.finki.songlibraryapplication.model.dto;


import lombok.Data;
import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Status;

import java.time.LocalDate;
import java.util.List;

@Data
public class PlaylistDto {
    private String name;
    private LocalDate dateOfCreation;
    private Status status;
    private List<Song> existingSongs;

}
