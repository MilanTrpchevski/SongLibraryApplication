package mk.ukim.finki.songlibraryapplication.repository;

import mk.ukim.finki.songlibraryapplication.model.Playlist;
import mk.ukim.finki.songlibraryapplication.model.enumerations.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p WHERE p.status = :status AND SIZE(p.existingSongs) <= :maxSongs")
    List<Playlist> findPublicPlaylistsWithMax3Songs(@Param("status") Status status, @Param("maxSongs") int maxSongs);

    @Query("SELECT DISTINCT p FROM Playlist p JOIN p.existingSongs s WHERE s.artist.id = :artistId ORDER BY p.name ASC, s.artist.dateOfBirth ASC")
    List<Playlist> filterSongsByArtistNameAndArtistDateOfBirth(@Param("artistId") Long artistId);

    @Query("SELECT SUM(s.duration) FROM Playlist p JOIN p.existingSongs s WHERE p.id = :playlistId")
    Integer calculateTotalDuration(@Param("playlistId") Long playlistId);

}
