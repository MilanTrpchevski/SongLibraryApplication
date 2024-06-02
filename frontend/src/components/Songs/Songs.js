import React from "react";

const Songs = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Title</th>
                            <th scope={"col"}>Release Date</th>
                            <th scope={"col"}>Genre</th>
                            <th scope={"col"}>Duration</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.songs.map((term) => (
                            <tr key={term.id}>
                                <td>{term.title}</td>
                                <td>{term.releaseDate}</td>
                                <td>{term.genre}</td>
                                <td>{term.duration}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Songs;