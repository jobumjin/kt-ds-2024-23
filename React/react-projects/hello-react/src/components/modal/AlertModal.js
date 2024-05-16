import { forwardRef, useImperativeHandle, useRef } from "react";
/**
 * export : AlertModal 컴포넌트(함수)/변수/상수 등등을 외부로 공개하기 위한 방법
 * import {AlerModal} from "./path"
 *
 * export default :  AlertModal 컴포넌트(함수)/변수/상수 등등을 외부로 공개하기 위한 방법
 * AlertModal.js 파일을 Import 했을 때, 대표 컴포넌트/함수/변수/상수를 공개하는 방법
 * 하나의 js 파일에 하나의 exportdefault만 작성.
 * 한 파일 내에서 export default를 여러번 작성 x
 * import AlertModal, {Other Component} from "./path"
 */
// export default function AlertMoadl({ children }) {
const AlertModal = forwardRef(({ children, onClose }, ref) => {
  const modal = useRef();

  // props로 전달받은 ref의 current 값을 주입시키는 함수.
  useImperativeHandle(ref, () => {
    return {
      open() {
        modal.current.showModal();
      },
      close() {
        modal.current.close();
      },
    };
  });
  return (
    <dialog className="modal" ref={modal}>
      <div className="modal-body">
        <section className="modal-close-button" onClick={onClose}>
          X
        </section>
        {children}
      </div>
    </dialog>
  );
});

export default AlertModal;
