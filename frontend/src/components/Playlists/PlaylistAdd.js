import React from 'react';
import { useNavigate } from 'react-router-dom';
import SongLibraryRepository from "../../repository/SongLibraryRepository";

const PlaylistAdd = (props) => {
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        dateOfCreation: "",
        status: "",
        existingSongs: []
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const { name, dateOfCreation, status, existingSongs } = formData;

        SongLibraryRepository.addPlaylists(name, dateOfCreation, status, existingSongs)
            .then(() => navigate("/api/playlists"))
            .catch((error) => {
                console.error("Error adding playlist:", error);
            });
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Playlist Name</label>
                        <input type="text" className="form-control" id="name" name="name" required placeholder="Enter playlist name" onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="dateOfCreation">Date of Creation</label>
                        <input type="date" className="form-control" id="dateOfCreation" name="dateOfCreation" required onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="status">Status</label>
                        <input type="text" className="form-control" id="status" name="status" required placeholder="Status" onChange={handleChange} />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );
};

export default PlaylistAdd;
