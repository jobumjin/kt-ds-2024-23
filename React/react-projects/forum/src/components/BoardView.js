import { useCallback, useMemo, useState } from "react";
import ModifyBoardForm from "./ModifyBoardForm";
import { deleteBoard, loadDetailBoard } from "../http/http";
import { useFetch } from "../hooks/useFetch";

export default function BoardView({
  selectedBoardId,
  setSelectedBoardId,
  token,
  setNeedReload,
  memberItem,
  setIsButtonRemoveMode,
  // setBoardItem,
  // boardItem,
  needReload,
}) {
  const [isModifyMode, setIsModifyMode] = useState(false);

  //   const url = "http://localhost:8080/api/v1/boards/" + selectedBoardId;
  const fetchLoadDetailBoard = useCallback(loadDetailBoard, []);

  const fetchParam = useMemo(() => {
    return { selectedBoardId, token, needReload };
  }, [selectedBoardId, token, needReload]);

  const { data, isLoading } = useFetch(
    undefined,
    fetchLoadDetailBoard,
    fetchParam
  );

  const { body: boardItem } = data || {};

  const onModifyClickHandler = () => {
    setIsModifyMode(true);
  };

  const onDeleteClickHandler = async () => {
    const json = await deleteBoard(token, selectedBoardId);
    if (json.body) {
      // 삭제 성공
      // 목록 컴포넌트를 노출.
      setSelectedBoardId(undefined);
      setIsButtonRemoveMode(false);
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
          {isLoading && <div>데이터를 불러오는 중입니다.</div>}
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
          setSelectedBoardId={setSelectedBoardId}
        />
      )}
    </div>
  );
}
