import { useCallback, useMemo, useState } from "react";
import BoardView from "./BoardView";
import WriteModeFrom from "./WriteBoardForm";
import { loadBoardList } from "../http/http";
import { useFetch } from "../hooks/useFetch";

let pageNo = 0;
export default function BoardApp({ token, memberItem }) {
  // const [boardItem, setBoardItem] = useState();
  // const [boards, setBoards] = useState([]);
  const [selectedBoardId, setSelectedBoardId] = useState();
  const [isWriteMode, setIsWriteMode] = useState(false);
  const [isButtonRemoveMode, setIsButtonRemoveMode] = useState(false);
  const [needReload, setNeedReload] = useState();

  const isSelect = selectedBoardId !== undefined;

  const fetchLoadBoardList = useCallback(loadBoardList, []);

  const fetchParam = useMemo(() => {
    return { token, needReload };
  }, [token, needReload]);

  const { data, setData } = useFetch(undefined, fetchLoadBoardList, fetchParam);
  const { count, pages, next } = data || {};
  const { body: boards } = data || {};
  console.log(data);
  // 게시글 불러오기
  // useEffect(() => {
  //   const loadBoard = async () => {
  //     const json = await loadBoardList(token);
  //     // console.log(json);
  //     setBoards(json.body);
  //   };
  //   loadBoard();
  // }, [token, needReload]);

  const onRowClickHandler = (rowId) => {
    // console.log(rowId);
    setSelectedBoardId(rowId);
    setIsButtonRemoveMode(true);
  };

  const onLoadMoreClickHandler = async () => {
    const json = await loadBoardList({ token, pageNo: ++pageNo });
    setData((prevData) => {
      return {
        ...prevData,
        next: json.next,
        pages: json.pages,
        errors: json.errors,
        count: json.count,
        body: [...prevData.body, ...json.body],
      };
    });
  };

  const onWriteModeClickHandler = () => {
    setIsWriteMode(true);
  };

  return (
    <>
      {token && !isSelect && !isWriteMode && boards && (
        <>
          <div>총 {count}개의 게시물이 검색되었습니다.</div>
          <table>
            <thead>
              <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성일</th>
              </tr>
            </thead>
            <tbody>
              {boards.map((BItem) => (
                <tr key={BItem.id} onClick={() => onRowClickHandler(BItem.id)}>
                  <td>{BItem.id}</td>
                  <td>{BItem.subject}</td>
                  <td>{BItem.memberVO.name}</td>
                  <td>{BItem.viewCnt}</td>
                  <td>{BItem.crtDt}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
      {token && isSelect && !isWriteMode && (
        <BoardView
          needReload={needReload}
          selectedBoardId={selectedBoardId}
          setSelectedBoardId={setSelectedBoardId}
          token={token}
          setNeedReload={setNeedReload}
          memberItem={memberItem}
          setIsWriteMode={setIsWriteMode}
          // boardItem={boardItem}
          // setBoardItem={setBoardItem}
          setIsButtonRemoveMode={setIsButtonRemoveMode}
        />
      )}
      {isWriteMode && (
        <WriteModeFrom
          setIsWriteMode={setIsWriteMode}
          token={token}
          setNeedReload={setNeedReload}
        />
      )}
      {!token && <div>로그인이 필요합니다.</div>}
      {token && !isWriteMode && !isButtonRemoveMode && (
        <div className="button-area right-align">
          {next && <button onClick={onLoadMoreClickHandler}>더보기</button>}
          <button onClick={onWriteModeClickHandler}>게시글 등록</button>
        </div>
      )}
    </>
  );
}
