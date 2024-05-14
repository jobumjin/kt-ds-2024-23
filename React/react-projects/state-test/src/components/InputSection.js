import { useState } from "react";

export function InputSection({ setTextArray }) {
  // 텍스트를 관리하는 state
  // 기본값 : undefined
  const [text, setText] = useState();

  const onKeyUpHandler = (event) => {
    const textValue = event.currentTarget.value;
    setText(textValue);
  };

  const onClickHandler = () => {
    // setTextArray([...textArray, text]);
    setTextArray((prevState) => [...prevState, text]);
    // setText(""); 도전 해보려했지만 안됨
  };

  return (
    <div>
      <input
        type="text"
        placeholder="텍스트를 입력하세요."
        // defaultValue={text}
        onKeyUp={onKeyUpHandler}
      />
      <button onClick={onClickHandler}>저장</button>
    </div>
  );
}
