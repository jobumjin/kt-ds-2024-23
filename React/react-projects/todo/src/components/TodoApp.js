import { useCallback, useMemo } from "react";
import AddTodo from "./AddTodo.js";
import Todo from "./Todo.js";

export default function TodoApp({ todo, setTodo }) {
  console.log("Run TodoApp");

  // const obj = useMemo(() => {
  //   return { A: 1, B: 2, todo: todo };
  // }, []);

  const flexStyles = useMemo(() => {
    return {
      display: "flex",
      padding: "0.5rem",
      marginTop: "1rem",
    };
  }, []);

  const styles = {
    backgroundColor: "#FFF",
    margin: "0 auto",
    marginTop: "1rem",
    width: "50rem",
  };

  // [] <== Component가 처음 실행될 때에만 동작 (의존 배열)
  // const fn = useCallback(() => {}, []);

  // [todo] <== todo 가 변경되었다면, 함수를 재생성하는 의존 배열
  //            todo 가 변경되었을 때 동작.
  // const fn = useCallback(() => {}, [todo]);

  const onTodoHandler = useCallback(
    (task, dueDate) => {
      setTodo((prevTodos) => [
        ...prevTodos,
        {
          id: prevTodos.length,
          isDone: false,
          task: task,
          dueDate: dueDate,
        },
      ]);
    },
    [setTodo]
  );

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
          <Todo
            key={todo.id}
            todo={todo}
            onDone={onDoneHandler}
            style={flexStyles}
          />
        ))}
      </ul>
      <AddTodo onAdd={onTodoHandler} style={flexStyles} />
    </div>
  );
}
