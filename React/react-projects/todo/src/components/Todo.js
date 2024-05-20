/**
 * Todo Item을 관리하는 Component
 *
 * props: todo = {id:"", task:"", duDate:"", isDone:false}
 *        onDone = function();
 */
export default function Todo({ todo, onDone, style }) {
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

  return (
    <li style={styles}>
      <div style={{ marginRight: "1rem" }}>
        <input
          key={id}
          defaultValue={id}
          type="checkbox"
          checked={isDone ? "checked" : ""}
          onChange={onDone}
        />
      </div>
      <div style={{ flexGrow: 1 }}>{task}</div>
      <div>{dueDate}</div>
    </li>
  );
}
