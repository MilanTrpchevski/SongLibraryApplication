import React from 'react';
import { Link } from 'react-router-dom';

const Header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
                <a className="navbar-brand" href="/">Song Library Application</a>

                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <Link className="nav-link" to="/api/artists">Artists</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to="/api/playlists">Playlists</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to="/api/songs">Songs</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to="/api/add-artist">Add Artist</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to="/api/add-playlist">Add Playlist</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to="/api/add-song">Add Song</Link>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    );
}

export default Header;
