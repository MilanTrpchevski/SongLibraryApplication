package mk.ukim.finki.songlibraryapplication.model.dto;


import lombok.Data;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Genre;

import java.time.LocalDate;

@Data
public class SongDto {
    private String title;
    private int duration;
    private LocalDate releaseDate;
    private Genre genre;
}
