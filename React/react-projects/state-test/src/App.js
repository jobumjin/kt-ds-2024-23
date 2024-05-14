import { DataSection } from "./components/DataSection.js";
import { InputSection } from "./components/InputSection.js";
import { useState } from "react";

function App() {
  // 지금까지 입력한 text를 관리하는 배열 state
  // 기본값 : undefined => []
  const [textArray, setTextArray] = useState([]);

  return (
    <div>
      <InputSection setTextArray={setTextArray} />
      <DataSection textArray={textArray} />
    </div>
  );
}

export default App;
