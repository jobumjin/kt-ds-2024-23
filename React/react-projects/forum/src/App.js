import { useCallback, useMemo, useState } from "react";
import Header from "./components/Header.js";
import BoardApp from "./components/BoardApp.js";
import { loadMyData } from "./http/http.js";
import { useFetch } from "./hooks/useFetch.js";
// import { useTimeout } from "./hooks/timeout.js";

export default function App() {
  const [token, setToken] = useState();

  // Hook 연습.. Hook은 굉장히 강력하고.. 독립적이다..
  // Hook은 상수안에서 호출하는 친구들은 사용할 수 없다..
  // const { data, isLoading } = useTimeout();
  const fetchLoadMyData = useCallback(() => {
    if (token) {
      return loadMyData;
    } else {
      return () => {
        return undefined;
      };
    }
  }, [token]);
  const fetchToken = useMemo(() => {
    return { token };
  }, [token]);

  const { data } = useFetch(undefined, fetchLoadMyData(), fetchToken);
  // data 가 undefined 라면 {}를 할당.. 아니라면 data 할당
  const { body: memberItem } = data || {};

  return (
    <div className="main-container">
      {/* {isLoading ? <div>데이터를 불러오는 중입니다.</div> : <div>{data}</div>} */}
      <Header token={token} setToken={setToken} memberItem={memberItem} />
      <main>
        <BoardApp token={token} memberItem={memberItem} />
      </main>
    </div>
  );
}

// function App() {
//   // 서버가 발행해준 토큰을 기억하기 위한 state 생성.
//   const [token, setToken] = useState();

//   // React 에서 Spring Server로 데이터를 요청.
//   // API로만 통신. (요청 JSON ---> JSON 응답)
//   // AJAX --> iframe + From Request
//   //          form 요청 --> JSON / HTML
//   // API --> Browser --> Server
//   //        JSON 요청 --> JSON

//   // JavaScript의 내장함수 (API 오청.)
//   // 비동기 통신.
//   // await가 동작하기 위해서는 상위 함수가 async 함수여야 한다.
//   // const promise = await fetch("URL", Header ==> []);

//   // Spring Server에 접근하기위한 JWT 발급.

//   useEffect(() => {
//     const loadToken = async () => {
//       const response = await fetch("http://localhost:8080/auth/token", {
//         body: JSON.stringify({
//           email: "rkskek@rkskek.comf",
//           password: "qwerT12345",
//         }),
//         method: "POST",
//         headers: { "Content-Type": "application/json" },
//       });
//       console.log(response);
//       // response에서 body의 값을 알고 싶을 때 , response.json()을 호출.
//       // response.json()함수 또한 비동기 함수
//       // await response.json();
//       const body = await response.json();
//       console.log(body);
//       setToken(body.token + Math.random());
//     };

//     loadToken();
//   }, []);

//   // 이 컴포넌트가 실행될 때, 아이디와 패스워드를 통해
//   // 서버에게 로그인을 시도한다.
//   // 로그인 결과인 token을 가져와서 브라우저가 기억하도록 해야한다.

//   return <>{token}</>;
// }

// export default App;
