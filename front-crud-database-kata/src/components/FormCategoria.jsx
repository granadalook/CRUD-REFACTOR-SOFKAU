import { useContext, useState, useRef } from "react";
import { Store } from "../state/StoreProvider";

const FormCategory = () => {
  const formRef = useRef(null);

  const [category, setCategory] = useState("");

  const { state, dispatch } = useContext(Store);

  const onAdd = async (event) => {
    event.preventDefault();
    if (category) {
      const categoryForm = {
        name: category,
        notes: [],
      };
      let categorieSavedPromise = await fetch(
        `http://localhost:8080/api/create/category`,
        {
          method: "POST",
          headers: {
            "Content-type": "application/json",
          },
          body: JSON.stringify(categoryForm),
        }
      );

      let categoriSaved = await categorieSavedPromise.json();

      dispatch({
        type: "add-category",
        payload: categoriSaved,
      });
      formRef.current.reset();
    }
    setCategory("");
  };

  const addCategory = (event) => {
    const entryCategory = event.target.value;
    setCategory(entryCategory);
  };

  return (
    <div>
      <h1 className=" text-center">
        <b>AGREGAR CATEGORIA</b>
      </h1>
      <form ref={formRef} className="form-control  border border-5 mt-5 ">
        <input
          className="form-control  form-control-lg mt-3 "
          onChange={addCategory}
          type="text"
          name="category"
          placeholder="Ingresa el nombre de la categoria"
        />
        <div className="d-grid gap-2 col-6 mx-auto m-3">
          <button className="btn btn-success" onClick={onAdd}>
            <b> NUEVA CATEGORIA</b>
          </button>
        </div>
      </form>
    </div>
  );
};

export default FormCategory;
