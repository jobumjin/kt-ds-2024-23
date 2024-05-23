import { useRef } from "react";
import { useDispatch } from "react-redux";
import { doneTodo } from "../stores/toolkit/store";

/**
 * Todo Item을 관리하는 Component
 *
 * props: todo = {id:"", task:"", duDate:"", isDone:false}
 */
export default function Todo({ todo, style }) {
  console.log("Run Todo");
  const { id, isDone, task, dueDate } = todo;

  const styles = {
    // 우리가 받아온 style의 내용을 가져온다.
    ...style,
    borderBottom: "1px solid #ccc",
    // padding 은 overWrite해준다..?
    padding: "1rem",
    display: "flex",
    color: isDone ? "#ccc" : "#333",
    textDecoration: isDone ? "line-through" : "none",
  };

  const checkboxRef = useRef();
  const todoDispatch = useDispatch();
  const onDoneHandler = () => {
    const checkbox = checkboxRef.current;
    const checked = checkbox.checked;

    // todo dispatch 코드
    todoDispatch(
      doneTodo({
        id,
        task,
        dueDate,
        isDone: checked,
      })
    );

    //toolkit dispatch 코드
    // todoDispatch(todoActions.done({ id, isDone: checked }));

    // react-redux dispatch 코드
    // const payload = { id, isDone: checked };
    // todoDispatch({ type: "DONE", payload });
  };

  return (
    <li style={styles}>
      <div style={{ marginRight: "1rem" }}>
        <input
          key={id}
          defaultValue={id}
          type="checkbox"
          checked={isDone ? "checked" : ""}
          onChange={onDoneHandler}
          ref={checkboxRef}
        />
      </div>
      <div style={{ flexGrow: 1 }}>{task}</div>
      <div>{dueDate}</div>
    </li>
  );
}
