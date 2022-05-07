import { useContext, useState, useRef } from "react";

const EditarTarea = ({ updateNote, note }) => {
  const formRef = useRef(null);

  const [noteTitle, setNoteTitle] = useState("");

  const editNote = (event) => {
    const editedNote = event.target.value;
    if (editedNote) {
      setNoteTitle(editedNote);
    }
  };

  return (
    <form ref={formRef}>
      <div className="d-flex align-items-center">
        <input
          className="form-control form-control-lg"
          onChange={editNote}
          type="text"
          name="editar tarea"
          placeholder="Editar tarea"
        />
        <button
          className="btn btn-warning me-2 m-1"
          onClick={(event) => updateNote(event, note, noteTitle, formRef)}
        >
          <b>EDITAR</b>
        </button>
      </div>
    </form>
  );
};

export default EditarTarea;
