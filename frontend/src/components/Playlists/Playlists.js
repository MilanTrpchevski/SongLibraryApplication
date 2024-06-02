import React from "react";

const Playlists = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Date of creation</th>
                            <th scope={"col"}>Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.playlists.map((term) => {
                            return (
                                <tr>
                                    <td>{term.name}</td>
                                    <td>{term.dateOfCreation}</td>
                                    <td>{term.status}</td>
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

export default Playlists;
