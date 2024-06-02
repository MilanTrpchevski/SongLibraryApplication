package mk.ukim.finki.songlibraryapplication.repository;

import mk.ukim.finki.songlibraryapplication.model.Playlist;
import mk.ukim.finki.songlibraryapplication.model.Song;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlaylistRepositoryTest {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;

    @Before
    public void init() {
        if (playlistRepository.count() == 0) {
            Song song1 = new Song();
            song1.setTitle("Song Title 1");
            songRepository.save(song1);

            Song song2 = new Song();
            song2.setTitle("Song Title 2");
            songRepository.save(song2);

            Playlist playlist1 = new Playlist();
            playlist1.setName("Playlist 1");
            playlistRepository.save(playlist1);

            Playlist playlist2 = new Playlist();
            playlist2.setName("Playlist 2");
            playlistRepository.save(playlist2);
        }
    }

    @Test
    public void testFindAll() {
        List<Playlist> playlists = playlistRepository.findAll();
        Assert.assertEquals(2, playlists.size());
    }

}
