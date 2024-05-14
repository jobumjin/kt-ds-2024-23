import { useState } from "react";
import { Input } from "./components/Input.js";
import { Table } from "./components/Table.js";

function App() {
  const [textArray, setTextArray] = useState([]);

  return (
    <div>
      <Input setTextArray={setTextArray}></Input>
      <Table textArray={textArray}></Table>
    </div>
  );
}

export default App;
