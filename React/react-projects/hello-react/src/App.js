import { DataSection } from "./components/DataSection.js";
import { Section } from "./components/Section.js";
//import 한 section의 위치를 적어줌
// ./ 현재경로의 compoenents의 Section.js
import { useState } from "react";

function App() {
  const [title, setTitle] = useState("Untitle");

  const onKeyUpHandler = (event) => {
    const value = event.currentTarget.value;
    // state를 변경시키는 setTitle이 호출되는 순간
    // AppComponent는 재실행 된다.
    // state는 Component가 최초로 실행될 때, 초깃값이 할당이 되고
    // state가 변경이 되어 AppComponent가 재실행이 되었을 때
    // title의 값은 마지막에 할당된 값으로 항상 유지.
    setTitle(value);
  };

  console.log("Run App Component");
  console.log("title state: ", title);

  //section의 내용을 클릭했을때 반응할 함수
  const onClickHandler = () => {
    alert("클릭했습니다!");
  };

  return (
    <main>
      {/* Props로 데이터를 전달할 때
      1. 문자열은 ""로 전송 
      2. 그 외 모든 데이터는 {}에 작성. */}
      <Section
        title={title}
        color="#F00"
        onKeyUp={onKeyUpHandler}
        onClick={onClickHandler}
      />
      <DataSection>State를 사용하지 않는 Component</DataSection>
    </main>
  );
}
export default App;
