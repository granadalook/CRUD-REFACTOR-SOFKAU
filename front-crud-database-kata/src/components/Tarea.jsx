import React, { useContext, useState } from "react";
import { Store } from "../state/StoreProvider";
import EditNote from "./EditarTarea";

const Note = ({ note, removeNote }) => {
  const { state, dispatch } = useContext(Store);

  const [showEdit, setShowEdit] = useState(false);

  const onChecked = async (event, note) => {
    const newNote = { ...note, done: !note.done };
    const checked = event.currentTarget.checked;
    console.log(newNote);
    let response = await fetch(`http://localhost:8080/api/update/note`, {
      method: "PUT",
      headers: {
        "Content-type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(newNote),
    });

    console.log(response);

    let noteUpdated = await response.json();
    console.log(noteUpdated);
    dispatch({
      type: "update-note",
      payload: noteUpdated,
    });
  };

  const updateNote = (event, note, noteTitle, formRef) => {
    event.preventDefault();
    const newNote = { ...note, title: noteTitle };
    dispatch({
      type: "update-note",
      payload: {
        note: newNote,
      },
    });

    formRef.current.reset();
  };

  const displayEdit = () => {
    setShowEdit(!showEdit);
  };

  return (
    <div className="border border-dark m-3 rounded border-2 d-flex justify-content-evenly bg-success p-2 text-dark bg-opacity-25">
      <h5 className="fw-bold m-2">{`${note.title}`}</h5>
      <button
        className="btn btn-danger me-2 m-1 "
        onClick={() => removeNote(note)}
      >
        ELIMINAR
      </button>
      <button className="btn btn-warning me-2 m-1" onClick={displayEdit}>
        EDITAR
      </button>
      {showEdit && <EditNote updateNote={updateNote} note={note} />}
      <div className="d-flex align-items-center">
        <label className="form-check-label fs-4 me-2">OK</label>
        <input
          className="form-check-input"
          type="checkbox"
          onChange={(event) => onChecked(event, note)}
          checked={note.done}
        />
      </div>
    </div>
  );
};

export default Note;
