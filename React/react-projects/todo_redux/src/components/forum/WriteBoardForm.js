import { useRef } from "react";
import { createBoard } from "../../http/http";

export default function WriteModeFrom({
  token,
  setIsWriteMode,
  setNeedReload,
}) {
  const subjectRef = useRef();
  const fileRef = useRef();
  const contentRef = useRef();

  const onCancelClickHandler = () => {
    setIsWriteMode(false);
    setNeedReload(Math.random());
  };

  // API File Upload는 불가능하다.. AJAX를 이용해볼 것이다. => fetch..
  const onSaveClickHandler = async () => {
    const subject = subjectRef.current.value;
    const content = contentRef.current.value;
    const file = fileRef.current.files[0]; // 선택된 파일의 배열을 가져온다..

    const json = await createBoard(subject, content, file, token);
    // console.log(json);
    if (json.errors) {
      json.errors.forEach((error) => {
        alert(error);
      });
    } else if (json.body) {
      setIsWriteMode(false);
      setNeedReload(Math.random());
    }
  };

  return (
    <div>
      <div>
        <label htmlFor="subject">제목</label>
        <input type="text" id="subject" ref={subjectRef} />
      </div>
      <div>
        <label htmlFor="file">첨부파일</label>
        <input type="file" id="file" ref={fileRef} />
      </div>
      <div>
        <label htmlFor="content">내용</label>
        <textarea type="text" id="content" ref={contentRef} />
      </div>
      <div className="button-area right-align">
        <button onClick={onCancelClickHandler}>취소</button>
        <button onClick={onSaveClickHandler}>등록</button>
      </div>
    </div>
  );
}
