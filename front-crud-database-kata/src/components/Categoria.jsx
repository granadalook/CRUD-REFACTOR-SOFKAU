import React from "react";

const Categoria = ({ category, removeCategory }) => {
  return (
    <div className="m-3     ">
      <div className="text-center">
        {" "}
        <b>
          <>{`${category.name}`}</>
        </b>
      </div>

      <button
        className="btn btn-danger ms-5"
        onClick={() => removeCategory(category.id)}
      >
        <b> ELIMINAR CATEGORIA</b>
      </button>
    </div>
  );
};

export default Categoria;
