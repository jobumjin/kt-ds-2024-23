import { useState } from "react";

export function Input({ setTextArray }) {
  const [name, setName] = useState();
  const [age, setAge] = useState();

  const onKeyUpNameHandler = (event) => {
    const textValue = event.currentTarget.value;
    setName(textValue);
  };
  const onKeyUpAgeHandler = (event) => {
    const textValue = event.currentTarget.value;
    setAge(textValue);
  };

  const inputValue = {
    name: name,
    age: age,
  };

  const onClickHandler = () => {
    // setTextArray([...textArray, text]);
    setTextArray((prevState) => [...prevState, inputValue]);
    // 거꾸로하기
    // setTextArray((prevState) => [inputValue, ...prevState]);
    // setText(""); 도전 해보려했지만 안됨
  };

  return (
    <div>
      Name :
      <input
        type="text"
        placeholder="이름을 입력하세요."
        onKeyUp={onKeyUpNameHandler}
        defaultValue={name}
      />
      <br />
      Age :
      <input
        type="text"
        placeholder="나이을 입력하세요."
        onKeyUp={onKeyUpAgeHandler}
        defaultValue={age}
      />
      <button onClick={onClickHandler}>저장</button>
    </div>
  );
}
