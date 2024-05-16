import { useRef, useState } from "react";
import { createPortal } from "react-dom";
import AlertModal from "./modal/AlertModal.js";
import Input from "./ui/Input.js";

export function RefComponent() {
  // state는 최소화하자..
  // ref는 DOM을 핸들링하기 위한 것이다.
  // const [showModal, setShowModal] = useState(false);
  const alertModalRef = useRef();
  const completModalRef = useRef();
  const [textArray, setTextArray] = useState([]);
  const textRef = useRef();

  const onClickHandler = () => {
    console.log(completModalRef);
    console.log(textArray);
    const text = textRef.current.get();
    // setShowModal(false);
    if (text === "") {
      //   alert("글을 입력해주세요.");
      //   setShowModal(true);
      alertModalRef.current.open();
      textRef.current.select();
      // return 을 하지 않으면.. 결국 글이 들어가게 된다.. 공백으로
      return;
    }

    completModalRef.current.open();
    textRef.current.select();

    setTextArray((prevState) => [text, ...prevState]);
    textRef.current.set("");
    textRef.current.select();
  };

  const onCloseModalHandler = () => {
    alertModalRef.current.close();
    textRef.current.select();
  };

  const onCloseCompletModalHandler = () => {
    completModalRef.current.close();
    textRef.current.select();
  };

  return (
    <div className="main-container">
      <Input id="text" type="text" title="TEXT" ref={textRef} />
      <button onClick={onClickHandler}>Save</button>
      <hr />
      <ul>
        {textArray.map((item, index) => (
          <li key={index}>{item}</li>
        ))}
      </ul>
      {createPortal(
        <AlertModal onClose={onCloseCompletModalHandler} ref={completModalRef}>
          <div>
            <h3>{textArray[0]}를 입력되었습니다.</h3>
          </div>
        </AlertModal>,
        document.querySelector("#modals")
      )}
      {createPortal(
        <AlertModal onClose={onCloseModalHandler} ref={alertModalRef}>
          <div>
            <h3>텍스트를 입력하세요~!</h3>
          </div>
        </AlertModal>,
        document.querySelector("#modals")
      )}
    </div>
  );
}
