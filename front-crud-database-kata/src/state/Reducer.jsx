function reducer(state, action) {
  switch (action.type) {
    case "get-categories":
      const newState = [...state, ...action.payload];
      return newState;

    case "add-note":
      if (action.payload) {
        const categoryParentNewNote = state.find(
          (category) => category.id === action.payload.fkCategoryId
        );
        const parentNotes = [...categoryParentNewNote.notes, action.payload];
        const parentWithNewNote = {
          ...categoryParentNewNote,
          notes: parentNotes,
        };
        const newState = state.map((category) =>
          category.id === action.payload.fkCategoryId
            ? { ...parentWithNewNote }
            : category
        );
        return newState;
      }
      return state;
    case "delete-note":
      const categoryParentToDelNote = state.find(
        (category) => category.id === action.payload.fkCategoryId
      );
      if (categoryParentToDelNote) {
        const notesWithDeleted = categoryParentToDelNote.notes.filter(
          (note) => note.id !== action.payload.id
        );
        const newState = state.map((category) =>
          category.id === categoryParentToDelNote.id
            ? { ...categoryParentToDelNote, notes: notesWithDeleted }
            : category
        );
        return newState;
      }
      return state;

    case "update-note":
      const categoryParentToUpdateNote = state.find(
        (category) => category.id === action.payload.fkCategoryId
      );
      if (categoryParentToUpdateNote) {
        const notesWithUpdated = categoryParentToUpdateNote.notes.map((note) =>
          note.id === action.payload.id ? { ...action.payload } : note
        );
        const newState = state.map((category) =>
          category.id === categoryParentToUpdateNote.id
            ? { ...categoryParentToUpdateNote, notes: notesWithUpdated }
            : category
        );
        return newState;
      }
      return state;

    case "add-category":
      if (action.payload) {
        const newState = [...state, action.payload];
        return newState;
      }
      return state;

    case "delete-category":
      return state.filter((category) => category.id !== action.payload.id);
  }
}

export default reducer;
