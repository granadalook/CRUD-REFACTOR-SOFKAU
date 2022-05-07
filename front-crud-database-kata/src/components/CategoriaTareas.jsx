import React, { useContext, useEffect, useState } from "react";
import { Store } from "../state/StoreProvider";
import Category from "./Categoria";
import FormNote from "./FormTarea";
import Note from "./Tarea";

const CategoryNote = () => {
  const { state, dispatch } = useContext(Store);
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

  const removeCategory = (categoryId) => {
    dispatch({
      type: "delete-category",
      payload: {
        id: categoryId,
      },
    });
  };

  useEffect(() => {
    let listOfCategories = fetchAllCategories().then((categories) => {
      let action = {
        type: "get-categories",
        payload: categories,
      };
      dispatch(action);
    });
  }, []);

  const fetchAllCategories = async () => {
    let response = await fetch(`http://localhost:8080/api/get/categories`);
    let data = await response.json();
    return data;
  };

  return (
    <div>
      <h2>
        {state.map((category) => (
          <div key={category.id}>
            <hr />
            <div className="m-5 border rounded-3 border-5 border-success">
              <Category category={category} removeCategory={removeCategory} />
              <div className="m-5">
                <FormNote categoryId={category.id} />
              </div>
              {category.notes.map((note) => (
                <Note key={note.id} removeNote={removeNote} note={note} />
              ))}
            </div>
          </div>
        ))}
      </h2>
    </div>
  );
};

export default CategoryNote;
