import { useRef } from "react";

export function InputSection({ setTextArray }) {
  // 텍스트를 관리하는 state
  // 기본값 : undefined
  const textRef = useRef();

  // const onKeyUpHandler = (event) => {
  //   const textValue = event.currentTarget.value;
  //   setText(textValue);
  // };

  const onClickHandler = () => {
    const text = textRef.current.value;
    // setTextArray([...textArray, text]);
    if (text === "") {
      alert("글을 입력해주세요.");
      textRef.current.focus();
    }

    setTextArray((prevState) => [...prevState, text]);
    // setText(""); 도전 해보려했지만 안됨
    textRef.current.value = "";
    textRef.current.focus();
  };

  return (
    <div>
      <input
        type="text"
        placeholder="텍스트를 입력하세요."
        // defaultValue={text}
        // onKeyUp={onKeyUpHandler}
        ref={textRef}
      />
      <button onClick={onClickHandler}>저장</button>
    </div>
  );
}
