package mk.ukim.finki.songlibraryapplication.repository;

import mk.ukim.finki.songlibraryapplication.model.Song;
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
public class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

    @Before
    public void init() {
        if (songRepository.count() == 0) {
            Song song1 = new Song();
            song1.setTitle("Song Title 1");
            song1.setDuration(4);
            song1.setReleaseDate(LocalDate.of(2020, 8, 15));

            Song song2 = new Song();
            song2.setTitle("Song Title 2");
            song2.setDuration(2);
            song2.setReleaseDate(LocalDate.of(2021, 3, 20));

            songRepository.save(song1);
            songRepository.save(song2);
        }
    }

    @Test
    public void testFindAll() {
        List<Song> songList = songRepository.findAll();
        Assert.assertEquals(2, songList.size());
    }

    @Test
    public void testFindByArtist() {
        List<Song> songs = songRepository.findTop3SongsByDuration(1, 5);
        Assert.assertEquals(1, songs.size());
        Assert.assertEquals(2, songs.get(0).getTitle());
    }

}
