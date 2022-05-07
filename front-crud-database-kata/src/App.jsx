import "./App.css";
import CategoriaTareas from "./components/CategoriaTareas";
import FormCategoria from "./components/FormCategoria";
import StoreProvider from "./state/StoreProvider";
import { Navbar } from "./components/Navbar";
import { Footer } from "./components/Footer";

function App() {
  return (
    <StoreProvider>
      <Navbar />
      <div className="m-5   ">
        <FormCategoria />
      </div>

      <div className="m-5  border border-2">
        <CategoriaTareas />{" "}
      </div>
      <Footer />
    </StoreProvider>
  );
}

export default App;
