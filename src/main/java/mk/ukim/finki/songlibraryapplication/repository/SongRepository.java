package mk.ukim.finki.songlibraryapplication.repository;

import mk.ukim.finki.songlibraryapplication.model.Song;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    //    List<Song> findAllById(List<Song> songs);
    @Query("SELECT s FROM Song s WHERE s.artist.id = :artistId AND s.genre = :genre ORDER BY s.duration DESC")
    Song findLongestSongByArtistAndGenre(@Param("artistId") Long artistId, @Param("genre") Genre genre);
    @Query("SELECT s FROM Song s WHERE s.duration BETWEEN :minDuration AND :maxDuration ORDER BY s.duration DESC")
    List<Song> findTop3SongsByDuration(@Param("minDuration") int minDuration, @Param("maxDuration") int maxDuration);

}
