import { useState } from "react";

/**
 * 함수의 이름이 use 로 시작하면 React는 Custom Hook 으로 인식한다.
 */
export function useTimeout() {
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  // 3000 === 3초 뒤에 실행..
  setTimeout(() => {
    setData((prevData) => [...prevData, "new Data"]);
    setIsLoading(false);
  }, 3000);

  return { data, isLoading };
}
