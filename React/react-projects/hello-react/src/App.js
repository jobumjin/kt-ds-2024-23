import { Section } from "./components/Section.js";
//import 한 section의 위치를 적어줌
// ./ 현재경로의 compoenents의 Section.js
import { DataSection } from "./components/DataSection.js";

function App() {
  //section의 내용을 클릭했을때 반응할 함수
  const onClickHandler = () => {
    alert("클릭했습니다!");
  };

  return (
    <main>
      <Section title="Section1" color="#F00" onClick={onClickHandler} />
      <Section title="Section2" color="#0F0" onClick={onClickHandler} />
      <Section title="Section3" color="#00F" onClick={onClickHandler} />
      <Section title="Section4" color="#FFF" onClick={onClickHandler} />
      <DataSection color="#FF0" onClick={onClickHandler}>
        <div>This is a DataSection Component</div>
        <Section title="Section in DataSection" color="#0FF" />
      </DataSection>
    </main>
  );
}
export default App;
