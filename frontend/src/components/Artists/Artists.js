import React from "react";

const Artists = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>ArtisticName</th>
                            <th scope={"col"}>Date of birth</th>
                            <th scope={"col"}>Nationality</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.artists.map((term) => {
                            return (
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.artisticName}</td>
                                    <td>{term.dateOfBirth}</td>
                                    <td>{term.nationality}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Artists;