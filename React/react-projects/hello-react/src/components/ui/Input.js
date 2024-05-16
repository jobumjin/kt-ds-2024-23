import { forwardRef, useImperativeHandle, useRef } from "react";
// export default function Input({ id, type, title }) {
const Input = forwardRef(({ id, type, title }, ref) => {
  const inputFunction = useRef();

  useImperativeHandle(ref, () => {
    return {
      get() {
        return inputFunction.current.value;
      },
      set(text) {
        inputFunction.current.value = text;
      },
      select() {
        inputFunction.current.focus();
      },
    };
  });
  return (
    <>
      <label htmlFor={id}>{title}</label>
      <input type={type} id={id} ref={inputFunction} />
    </>
  );
});

export default Input;
