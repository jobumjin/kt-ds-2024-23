import { useState } from "react";
import AddTodo from "./AddTodo.js";
import Todo from "./Todo.js";

export default function TodoApp() {
  const [todo, setTodo] = useState([]);
  const styles = {
    backgroundColor: "#FFF",
    margin: "0 auto",
    marginTop: "1rem",
    width: "50rem",
  };

  const onDoneHandler = (event) => {
    const checkbox = event.currentTarget;
    const id = parseInt(checkbox.value);

    setTodo((prevTodo) =>
      prevTodo.map((todo) => {
        if (todo.id === id) {
          todo.isDone = checkbox.checked;
        }
        return { ...todo };
      })
    );
  };

  return (
    <div style={styles}>
      <h4 style={{ padding: "1rem" }}>
        완료: {todo.filter((item) => item.isDone).length} / 미완료 :{" "}
        {todo.filter((item) => !item.isDone).length}
      </h4>
      <ul>
        {todo.map((todo) => (
          <Todo key={todo.id} todo={todo}>
            <input
              key={todo.id}
              defaultValue={todo.id}
              type="checkbox"
              checked={todo.isDone ? "checked" : ""}
              onChange={onDoneHandler}
            />
          </Todo>
        ))}
      </ul>
      <AddTodo setTodo={setTodo} />
    </div>
  );
}
