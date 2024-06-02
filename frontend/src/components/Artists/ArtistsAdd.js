import React from 'react';
import { useNavigate } from 'react-router-dom';
import SongLibraryRepository from "../../repository/SongLibraryRepository";

const ArtistsAdd = (props) => {
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        artisticName: "",
        dateOfBirth: "",
        nationality: ""
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const { name, artisticName, dateOfBirth, nationality } = formData;

        SongLibraryRepository.addArtists(name, artisticName, dateOfBirth, nationality, [])
            .then(() => navigate("/api/artists"))
            .catch((error) => {
                console.error("Error adding artist:", error);
            });
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Artist Name</label>
                        <input type="text" className="form-control" id="name" name="name" required placeholder="Enter artist name" onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="artisticName">Artistic Name</label>
                        <input type="text" className="form-control" id="artisticName" name="artisticName" required placeholder="Enter artistic name" onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="dateOfBirth">Date of Birth</label>
                        <input type="date" className="form-control" id="dateOfBirth" name="dateOfBirth" required onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="nationality">Nationality</label>
                        <input type="text" className="form-control" id="nationality" name="nationality" required placeholder="Nationality" onChange={handleChange} />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );
};

export default ArtistsAdd;
