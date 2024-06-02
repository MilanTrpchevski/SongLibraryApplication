package mk.ukim.finki.songlibraryapplication.model.dto;


import lombok.Data;
import mk.ukim.finki.songlibraryapplication.model.Song;

import java.time.LocalDate;
import java.util.List;
@Data
public class ArtistDto {
    private String name;
    private String artisticName;
    private LocalDate dateOfBirth;
    private String nationality;
    private List<Song> songs;

}
