import './App.css';
import React, { Component } from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from '../Header/Header';
import Artists from "../Artists/Artists";
import Playlists from "../Playlists/Playlists";
import SongAdd from "../Songs/SongAdd";
import PlaylistAdd from "../Playlists/PlaylistAdd";
import ArtistsAdd from "../Artists/ArtistsAdd";
import Songs from "../Songs/Songs";
import SongLibraryRepository from "../../repository/SongLibraryRepository";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            artists: [],
            playlists: [],
            songs: []
        };
    }

    componentDidMount() {
        this.fetchData();
    }

    fetchData = () => {
        this.loadArtists();
        this.loadPlaylists();
        this.loadSongs();
    };

    loadArtists = () => {
        SongLibraryRepository.fetchArtists()
            .then((data) => {
                this.setState({ artists: data.data });
            })
            .catch((error) => {
                console.error("Error loading artists:", error);
            });
    };

    loadPlaylists = () => {
        SongLibraryRepository.fetchPlaylists()
            .then((data) => {
                this.setState({ playlists: data.data });
            })
            .catch((error) => {
                console.error("Error loading playlists:", error);
            });
    };

    loadSongs = () => {
        SongLibraryRepository.fetchSongs()
            .then((data) => {
                this.setState({ songs: data.data });
            })
            .catch((error) => {
                console.error("Error loading songs:", error);
            });
    };

    handleDataFetched = (data) => {
        // Assuming the fetched data might contain artists, songs, and playlists
        if (data.artists) {
            this.setState({ artists: data.artists });
        }
        if (data.playlists) {
            this.setState({ playlists: data.playlists });
        }
        if (data.songs) {
            this.setState({ songs: data.songs });
        }
    };

    render() {
        return (
            <Router>
                <Header />
                <main>
                    <div className="container">
                        <Routes>
                            <Route
                                path="/"
                                element={
                                    <>
                                        <div>
                                            <span>Artists</span>
                                            <Artists artists={this.state.artists}/>
                                            <span>Songs</span>
                                            <Songs songs={this.state.songs}/>
                                            <span>Playlists</span>
                                            <Playlists playlists={this.state.playlists}/>
                                        </div>
                                    </>
                                }
                            />
                            <Route path="/api/artists" element={<Artists artists={this.state.artists} />} />
                            <Route path="/api/playlists" element={<Playlists playlists={this.state.playlists} />} />
                            <Route path="/api/songs" element={<Songs songs={this.state.songs} />} />
                            <Route path="/api/add-artist" element={<ArtistsAdd />} />
                            <Route path="/api/add-song" element={<SongAdd />} />
                            <Route path="/api/add-playlist" element={<PlaylistAdd />} />
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }
}

export default App;
