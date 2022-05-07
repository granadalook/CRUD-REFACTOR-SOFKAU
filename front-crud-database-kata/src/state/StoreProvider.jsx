import React, { createContext, useReducer } from "react";
import reducer from "./Reducer";

const initialState = [
  {
    id: "0",
    name: "Categoria  0",
    notes: [
      {
        id: "0",
        title: "Tarea 0",
        done: false,
        fkCategoryId: "0",
      },
    ],
  },
  {
    id: "1",
    name: "Categoria 1",
    notes: [
      {
        id: "1",
        title: "Tarea 0",
        done: false,
        fkCategoryId: "1",
      },
      {
        id: "2",
        title: "Tarea 1",
        done: false,
        fkCategoryId: "1",
      },
    ],
  },
];

const Store = createContext(initialState);

const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};

export default StoreProvider;

export { Store, initialState };
