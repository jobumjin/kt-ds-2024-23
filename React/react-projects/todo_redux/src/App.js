import TodoApp from "./components/TodoApp.js";
// import ReduxProvider from "./stores/redux/store.js";
import ToolkitProvider from "./stores/toolkit/store.js";

function App() {
  console.log("Run App");

  // return (
  //   <ReduxProvider>
  //     <TodoApp />
  //   </ReduxProvider>
  // );
  return (
    <ToolkitProvider>
      <TodoApp />
    </ToolkitProvider>
  );
}

export default App;
