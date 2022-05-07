function reducer(state, action) {
  switch (action.type) {
    case "add-note":
      const newNote = {
        id: Math.floor(Math.random() * 100),
        title: action.title,
        done: false,
        fkCategoryId: action.categoryId,
      };
      console.log(newNote);
      if (newNote) {
        const categoryParentNewNote = state.find(
          (category) => category.id === action.categoryId
        );
        const parentNotes = [...categoryParentNewNote.notes, newNote];
        const parentWithNewNote = {
          ...categoryParentNewNote,
          notes: parentNotes,
        };
        console.log(parentWithNewNote);
        const newState = state.map((category) =>
          category.id === action.categoryId
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
          note.id === action.payload.id
            ? { ...note, title: action.newTitle }
            : note
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
      const newCategory = {
        id: Math.floor(Math.random() * 100),
        name: action.name,
        notes: [],
      };
      if (newCategory) {
        const newState = [...state, newCategory];
        return newState;
      }
      return state;

    case "delete-category":
      return state.filter((category) => category.id !== action.payload.id);
  }
}

export default reducer;
