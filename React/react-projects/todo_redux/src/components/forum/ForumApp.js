import { useCallback, useMemo, useState } from "react";
import BoardApp from "./BoardApp";
import Header from "./Header";
import { useFetch } from "../../hooks/useFetch.js";
import { loadMyData } from "../../http/http.js";

export default function ForumApp() {
  const [token, setToken] = useState();

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
  const { body: memberItem } = data || {};

  return (
    <>
      <Header token={token} setToken={setToken} memberItem={memberItem} />
      <main>
        <BoardApp token={token} memberItem={memberItem} />
      </main>
    </>
  );
}
