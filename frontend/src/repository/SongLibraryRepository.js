import axios from '../custom-axios/axios';

const SongLibraryRepository = {
    fetchArtists: () => {
        return axios.get("/artists");
    },
    fetchSongs: () => {
        return axios.get("/songs");
    },
    fetchPlaylists: () => {
        return axios.get("/playlists");
    },
    deletePlaylists: (id) => {
        return axios.delete(`/playlists/${id}`);
    },
    addArtists: (name, artisticName, dateOfBirth, nationality, songs) => {
        return axios.post("/artists", {
            name,
            artisticName,
            dateOfBirth,
            nationality,
            songs
        });
    },
    addPlaylists: (name, dateOfCreation, status, existingSongs) => {
        return axios.post("/playlists", {
            name,
            dateOfCreation,
            status,
            existingSongs
        });
    },
    addSongs: (title, duration, releaseDate, genre) => {
        return axios.post("/songs", {
            title,
            duration,
            releaseDate,
            genre
        });
    },

    // New API methods
    fetchArtistsBornBefore1999WithNationalityMacedonian: () => {
        return axios.get("/artists/before-1999-macedonian");
    },
    getArtistDetails: (id) => {
        return axios.get(`/artists/details/${id}`);
    },
    getLongestSongByArtistAndGenre: (artistId, genre) => {
        return axios.get(`/songs/longest/${artistId}/${genre}`);
    },
    getPlaylistsByArtist: (artistId) => {
        return axios.get(`/playlists/by-artist/${artistId}`);
    },
    getPublicPlaylistsWithMax3Songs: () => {
        return axios.get("/playlists/public-max3");
    },
    calculateTotalDuration: (playlistId) => {
        return axios.get(`/playlists/total-duration/${playlistId}`);
    },
    addSongToPlaylist: (playlistId, songId) => {
        return axios.post(`/playlists/${playlistId}/add-song/${songId}`);
    },
    getTop3SongsByDuration: (minDuration, maxDuration) => {
        return axios.get("/songs/top3", {
            params: { minDuration, maxDuration }
        });
    }
};

export default SongLibraryRepository;
