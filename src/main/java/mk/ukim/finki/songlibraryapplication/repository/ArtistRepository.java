package mk.ukim.finki.songlibraryapplication.repository;

import mk.ukim.finki.songlibraryapplication.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
//    @Query("SELECT DISTINCT a FROM Artist a LEFT JOIN FETCH a.songs s ORDER BY s.title DESC")

    List<Artist> findByDateOfBirthBeforeAndNationality(LocalDate date, String nationality);
    Artist findByArtisticName(String artisticName);

    List<Artist> findByNationality(String american);
}
