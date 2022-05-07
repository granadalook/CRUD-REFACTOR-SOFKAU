import React, { useContext } from "react";

const Tarea = ({ note, removeNote, updateNote }) => {
  return (
    <div className="border border-dark m-3 rounded border-2 d-flex justify-content-evenly bg-success p-2 text-dark bg-opacity-25">
      <h5 className="fw-bold m-2">{`${note.title}`}</h5>
      <div>
        {" "}
        <button
          className="btn btn-danger me-2 m-1 "
          onClick={() => removeNote(note.id)}
        >
          Remove
        </button>
        <button className="btn btn-warning" onClick={() => updateNote(note.id)}>
          Edit
        </button>
      </div>
    </div>
  );
};

export default Tarea;
