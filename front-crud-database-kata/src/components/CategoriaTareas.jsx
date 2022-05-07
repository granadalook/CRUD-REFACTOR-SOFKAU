import React, { useContext, useState } from "react";
import { Store } from "../state/StoreProvider";
import Categoria from "./Categoria";
import FormTarea from "./FormTarea";
import Tarea from "./Tarea";

const CategoryNote = () => {
  const [category, setCategory] = useState({});
  const [name, setName] = useState("");
  const [id, setId] = useState("");
  const [notesList, setNotesList] = useState([]);

  const removeNote = (note) => {
    dispatch({
      type: "delete-note",
      payload: note,
    });
  };

  const updateNote = (note) => {
    dispatch({
      type: "update-note",
      payload: note,
      newTitle: "prueba",
    });
  };

  const removeCategory = (categoryId) => {
    dispatch({
      type: "delete-category",
      payload: {
        id: categoryId,
      },
    });
  };

  const { state, dispatch } = useContext(Store);

  return (
    <div>
      <h2>
        {state.map((category) => (
          <div key={category.id}>
            <hr />

            <div className="m-5 border rounded-3 border-5 border-success">
              {" "}
              <Categoria category={category} removeCategory={removeCategory} />
              <div className="m-5">
                {" "}
                <FormTarea categoryId={category.id} />
              </div>
              {category.notes.map((note) => (
                <Tarea key={note.id} removeNote={removeNote} note={note} />
              ))}{" "}
            </div>
          </div>
        ))}
      </h2>
    </div>
  );
};

export default CategoryNote;
