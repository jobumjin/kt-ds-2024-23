import { useRef } from "react";
import { modifyBoard } from "../../http/http";

export default function ModifyBoardForm({
  token,
  setIsModifyMode,
  setNeedReload,
  boardItem,
  selectedBoardId,
  setSelectedBoardId,
}) {
  const subjectRef = useRef();
  const fileRef = useRef();
  const contentRef = useRef();

  const onCancelClickHandler = () => {
    setIsModifyMode(false);
  };

  // API File Upload는 불가능하다.. AJAX를 이용해볼 것이다. => fetch..
  const onSaveClickHandler = async () => {
    const subject = subjectRef.current.value;
    const content = contentRef.current.value;
    const file = fileRef.current.files[0]; // 선택된 파일의 배열을 가져온다..

    // 파일 업로드를 위해 formData생성
    const formData = new FormData(); // javascript bulit-in 객체.
    formData.append("subject", subject);
    formData.append("content", content);
    formData.append("file", file);

    const json = await modifyBoard(token, formData, selectedBoardId);
    // console.log(json);

    if (json.errors) {
      json.errors.forEach((error) => {
        alert(error);
      });
    } else if (json.body) {
      setIsModifyMode(false);
      setNeedReload(Math.random());
      setSelectedBoardId(selectedBoardId);
    }
  };

  return (
    <div>
      <div>
        <label htmlFor="subject">제목</label>
        <input
          type="text"
          id="subject"
          ref={subjectRef}
          defaultValue={boardItem.subject}
        />
      </div>
      <div>
        <label htmlFor="file">첨부파일</label>
        <input
          type="file"
          id="file"
          ref={fileRef}
          defaultValue={boardItem.file}
        />
      </div>
      <div>
        <label htmlFor="content">내용</label>
        <textarea
          type="text"
          id="content"
          ref={contentRef}
          defaultValue={boardItem.content}
        />
      </div>
      <div className="button-area right-align">
        <button onClick={onCancelClickHandler}>취소</button>
        <button onClick={onSaveClickHandler}>수정</button>
      </div>
    </div>
  );
}
