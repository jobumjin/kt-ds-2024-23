import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import AddTodo from "./AddTodo";
import { doneSubTodo, loadTodo } from "../../stores/toolkit/store";

export default function SubTodo() {
  //   const { id } = useParams();
  //   //   console.log("param : ", param);
  //   console.log(id);
  //   return <div>SubTodo 입니다.</div>;

  const sampleData = [
    {
      id: "sample1",
      isDone: false,
      task: "Sample Task1",
      dueDate: "2024-05-24",
    },
    {
      id: "sample2",
      isDone: true,
      task: "Sample Task2",
      dueDate: "2024-05-25",
    },
  ];

  const { id } = useParams();

  console.log("Run SubTodo", id);

  const styles = {
    display: "flex",
    borderBottom: "1px solid #ccc",
    padding: "1rem",
  };

  // React Router의 Path를 이동시키는 Hook
  // Spring의 redirect와 유사.
  const navigate = useNavigate();
  const onClickHandler = () => {
    navigate("/todo");
  };

  const todoDispatch = useDispatch();
  // firebase에서 모든 todo데이터 받아오는 코드
  // thuck 호출 필요.
  todoDispatch(loadTodo());

  // Redux Toolkit의 state를 받아온다.
  const todo = useSelector((state) =>
    state.todo.find((item) => item.id === parseInt(id))
  );

  const getSubTodoItems = () => {
    const todoArrays = [];
    for (let key in todo.sub) {
      //   console.log(key);
      todoArrays.push(todo.sub[key]);
    }
    return todoArrays;
  };

  const subItems = todo && todo.sub ? getSubTodoItems() : [];
  //   console.log(todo);
  //   console.log(subItems);

  const onDoneHandler = (event, item) => {
    // const checkbox = checkboxRef.current;
    // const checked = checkbox.checked;
    const checkbox = event.currentTarget;
    const checked = checkbox.checked;

    // thunk dispatch 코드
    todoDispatch(
      doneSubTodo({
        parentTodoId: parseInt(id),
        id: item.id,
        isDone: checked,
        task: item.task,
        dueDate: item.dueDate,
      })
    );
  };

  return (
    <>
      <h3 style={{ padding: "1rem" }}>"{todo && todo.task}"의 하위 목록</h3>
      <h4 style={{ padding: "1rem" }}>
        완료: {subItems.filter((item) => item.isDone).length} / 미완료 :{" "}
        {subItems.filter((item) => !item.isDone).length}
      </h4>
      <div className="button-area right-align">
        <button onClick={onClickHandler}>상위 목록으로 가기</button>
      </div>
      <ul>
        {subItems.map((SubTodo) => (
          <li
            key={SubTodo.id}
            style={{
              ...styles,
              color: SubTodo.isDone ? "#ccc" : "#333",
              textDecoration: SubTodo.isDone ? "line-through" : "none",
            }}
          >
            <div style={{ marginRight: "1rem" }}>
              <input
                type="checkbox"
                onChange={(event) => onDoneHandler(event, SubTodo)}
                key={SubTodo.id}
                defaultValue={SubTodo.id}
                checked={SubTodo.isDone}
              />
            </div>
            <div style={{ flexGrow: 1 }}>{SubTodo.task}</div>
            <div>{SubTodo.dueDate}</div>
          </li>
        ))}
      </ul>
      <AddTodo
        sub={true}
        parentTodoId={parseInt(id)}
        style={{ display: "flex", padding: "0.5rem", marginTop: "1rem" }}
      />
    </>
  );
}
