import React, { useContext, useState } from "react";
import { Store } from "../state/StoreProvider";
import EditarTarea from "./EditarTarea";

const Tarea = ({ note, removeNote }) => {
  const { state, dispatch } = useContext(Store);
  const [showEdit, setShowEdit] = useState(false);

  const onChecked = (event, note) => {
    const checked = event.currentTarget.checked;
    const newNote = { ...note, done: checked };
    dispatch({
      type: "update-note",
      payload: {
        note: newNote,
      },
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
      <div className="d-flex">
        {" "}
        <button
          className="btn btn-danger me-2 m-1 "
          onClick={() => removeNote(note.id)}
        >
          ELIMINAR
        </button>
        <button className="btn btn-warning me-2 m-1" onClick={displayEdit}>
          EDITAR
        </button>
        {showEdit && <EditarTarea updateNote={updateNote} note={note} />}
        <div className="d-flex align-items-center">
          <label className="form-check-label fs-4 me-2" for="defaultCheck1">
            OK
          </label>
          <input
            className="form-check-input"
            type="checkbox"
            id="defaultCheck1"
            onChange={(event) => onChecked(event, note)}
            checked={note.done}
          />
        </div>
      </div>
    </div>
  );
};

export default Tarea;
