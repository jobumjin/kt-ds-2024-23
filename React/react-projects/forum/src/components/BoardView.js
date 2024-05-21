import { useEffect, useState } from "react";
import ModifyBoardForm from "./ModifyBoardForm";

export default function BoardView({
  selectedBoardId,
  setSelectedBoardId,
  token,
  setNeedReload,
  memberItem,
  setIsButtonRemoveMode,
  setBoardItem,
  boardItem,
}) {
  const [isModifyMode, setIsModifyMode] = useState(false);

  //   const url = "http://localhost:8080/api/v1/boards/" + selectedBoardId;
  useEffect(() => {
    const loadBoard = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
        { method: "GET", headers: { Authorization: token } }
      );

      const json = await response.json();
      setBoardItem(json.body);
    };
    loadBoard();
  }, [token, selectedBoardId, setBoardItem]);

  const onModifyClickHandler = () => {
    setIsModifyMode(true);
  };

  const onDeleteClickHandler = async () => {
    const response = await fetch(
      `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
      { method: "DELETE", headers: { Authorization: token } }
    );
    const json = await response.json();
    if (json.body) {
      // 삭제 성공
      // 목록 컴포넌트를 노출.
      setSelectedBoardId(undefined);
      setNeedReload(Math.random());
    } else {
      // 삭제 실패
      // 실패한 사유를 알려줘야한다.
      console.log(json);
      alert(json.errors);
    }
  };

  const onListClickHandler = () => {
    setIsButtonRemoveMode(false);
    setSelectedBoardId(undefined);
    setNeedReload(Math.random());
  };

  return (
    <div>
      {!isModifyMode && (
        <div>
          {!boardItem && <div>데이터를 불러오는 중입니다.</div>}
          {boardItem && !isModifyMode && (
            <div>
              <h3>{boardItem.subject}</h3>
              <div>
                작성자: {boardItem.memberVO.name} ({boardItem.email})
              </div>
              <div>조회수: {boardItem.viewCnt}</div>
              <div>작성일: {boardItem.crtDt}</div>
              {boardItem.mdfyDt && <div>수정일: {boardItem.mdfyDt}</div>}
              {boardItem.originFileName && (
                <div>첨부파일: {boardItem.originFileName}</div>
              )}
              <div>
                <pre>{boardItem.content}</pre>
              </div>
            </div>
          )}
          <div className="button-area right-align">
            {boardItem &&
              memberItem &&
              (memberItem.email === boardItem.email ||
                memberItem.adminYn === "Y") && (
                <>
                  <button onClick={onModifyClickHandler}>수정</button>
                  <button onClick={onDeleteClickHandler}>삭제</button>
                </>
              )}
            <button onClick={onListClickHandler}>목록보기</button>
          </div>
        </div>
      )}

      {isModifyMode && (
        <ModifyBoardForm
          selectedBoardId={selectedBoardId}
          setIsModifyMode={setIsModifyMode}
          token={token}
          setNeedReload={setNeedReload}
          boardItem={boardItem}
        />
      )}
    </div>
  );
}
