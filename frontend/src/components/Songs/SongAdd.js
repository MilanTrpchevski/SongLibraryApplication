import React from 'react';
import { useNavigate } from 'react-router-dom';
import SongLibraryRepository from "../../repository/SongLibraryRepository";

const SongAdd = (props) => {
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        title: "",
        duration: "",
        releaseDate: "",
        genre: ""
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const { title, duration, releaseDate, genre } = formData;

        SongLibraryRepository.addSongs(title, duration, releaseDate, genre)
            .then(() => navigate("/api/songs"))
            .catch((error) => {
                console.error("Error adding song:", error);
            });
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="title">Song Title</label>
                        <input type="text" className="form-control" id="title" name="title" required placeholder="Enter song title" onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="releaseDate">Release Date</label>
                        <input type="date" className="form-control" id="releaseDate" name="releaseDate" required onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="genre">Genre</label>
                        <input type="text" className="form-control" id="genre" name="genre" required placeholder="Genre" onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="duration">Duration</label>
                        <input type="text" className="form-control" id="duration" name="duration" required placeholder="Duration" onChange={handleChange} />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );
};

export default SongAdd;
