package mk.ukim.finki.songlibraryapplication.repository;

import mk.ukim.finki.songlibraryapplication.model.Artist;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Before
    public void init() {
        if (artistRepository.count() == 0) {
            Artist artist1 = new Artist();
            artist1.setName("User user");
            artist1.setArtisticName("US");
            artist1.setNationality("Macedonian");
            artist1.setDateOfBirth(LocalDate.of(1985, 10, 15));

            Artist artist2 = new Artist();
            artist2.setName("User user2");
            artist2.setArtisticName("US2");
            artist2.setNationality("Macedonian2");
            artist2.setDateOfBirth(LocalDate.of(1990, 5, 20));

            artistRepository.save(artist1);
            artistRepository.save(artist2);
        }
    }

    @Test
    public void testFindAll() {
        List<Artist> artistList = artistRepository.findAll();
        Assert.assertEquals(2, artistList.size());
    }

    @Test
    public void testFindByNationality() {
        List<Artist> artists = artistRepository.findByNationality("Macedonian2");
        Assert.assertEquals(1, artists.size());
        Assert.assertEquals("User user2", artists.get(0).getName());
    }

    @Test
    public void testFindByArtisticName() {
        Artist artist = artistRepository.findByArtisticName("US2");
        Assert.assertNotNull(artist);
        Assert.assertEquals("User user2", artist.getName());
    }

    @Test
    public void testFindByDateOfBirthBeforeAndNationality() {
        List<Artist> artists = artistRepository.findByDateOfBirthBeforeAndNationality(
                LocalDate.of(1990, 1, 1), "Macedonian2");
        Assert.assertEquals(1, artists.size());
        Assert.assertEquals("User user2", artists.get(0).getName());
    }

    @Test
    public void testOptimisticLock() {
        Artist artist1 = artistRepository.findByArtisticName("US");
        Artist artist2 = artistRepository.findByArtisticName("US");

        artist1.setName("User");
        artist2.setName("User Updated");

        artistRepository.save(artist1);
        artistRepository.save(artist2);
    }
}
