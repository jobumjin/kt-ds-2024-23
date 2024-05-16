import { useRef } from "react";

export function Input({ setTextArray }) {
  // const [name, setName] = useState();
  // const [age, setAge] = useState();

  // const onKeyUpNameHandler = (event) => {
  //   const textValue = event.currentTarget.value;
  //   // setName(textValue);
  // };
  // const onKeyUpAgeHandler = (event) => {
  //   const textValue = event.currentTarget.value;
  //   // setAge(textValue);
  // };

  console.log("Run Input");
  const nameRef = useRef();
  const ageRef = useRef();

  const onClickHandler = () => {
    console.log("nameRef ===============");
    console.log("nameRef: ", nameRef);
    console.log("nameRef.current: ", nameRef.current);
    console.log("nameRef.current.value :", nameRef.current.value);
    console.log("ageRef ===============");
    console.log("ageRef: ", ageRef);
    console.log("ageRef.current: ", ageRef.current);
    console.log("ageRef.current.value :", ageRef.current.value);
    // setTextArray([...textArray, text]);

    // 담아주면.. 문제가 없다.. 왜냐하면 주소값을 바꿔주기 때문에..?
    const name = nameRef.current.value;
    const age = ageRef.current.value;

    if (name === "") {
      alert("이름을 입력하세요.");
      nameRef.current.focus();
      return;
    }
    if (age === "") {
      alert("skdl을 입력하세요.");
      ageRef.current.focus();
      return;
    }

    setTextArray((prevState) => [
      ...prevState,
      {
        name: name,
        age: age,
      },
    ]);
    // 거꾸로하기
    // setTextArray((prevState) => [inputValue, ...prevState]);
    // setText(""); 도전 해보려했지만 안됨 ㅋㅋㅋㅋ
    nameRef.current.value = "";
    ageRef.current.value = "";
    // setTimeout(() => {
    // nameRef.current.value = "";
    // ageRef.current.value = "";
    // }, 100);
    // 시간을 벌어주는 일...
    nameRef.current.focus();
  };

  return (
    <div>
      <div>
        <label htmlFor="name">Name :</label>
        {/** nameRef.current = <input type="text id="name" .../>*/}
        <input
          type="text"
          id="name"
          placeholder="이름을 입력하세요."
          ref={nameRef}
        />
      </div>
      <div>
        <label htmlFor="age">Age :</label>

        {/** nameRef.current = <input type="text id="name" .../>*/}
        <input
          type="number"
          id="age"
          placeholder="나이을 입력하세요."
          ref={ageRef}
        />
        <button onClick={onClickHandler}>저장</button>
      </div>
    </div>
  );
}
