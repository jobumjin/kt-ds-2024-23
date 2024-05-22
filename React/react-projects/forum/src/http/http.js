export const loadMyData = async ({ token }) => {
  const response = await fetch("http://localhost:8080/api/v1/member", {
    method: "GET",
    headers: {
      Authorization: token,
    },
  });

  const json = await response.json();
  return json;
};

export const login = async (email, password) => {
  const response = await fetch("http://localhost:8080/auth/token", {
    method: "POST",
    body: JSON.stringify({ email, password }),
    headers: { "Content-Type": "application/json" },
  });

  const json = await response.json();
  return json;
};

export const loadBoardList = async ({ token, pageNo = 0 }) => {
  if (!token) {
    return undefined;
  }

  const response = await fetch(
    `http://localhost:8080/api/v1/boards?pageNo=${pageNo}`,
    {
      method: "GET",
      headers: { Authorization: token },
    }
  );

  const json = await response.json();
  return json;
};

export const loadDetailBoard = async ({ selectedBoardId, token }) => {
  const response = await fetch(
    `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
    { method: "GET", headers: { Authorization: token } }
  );

  const json = await response.json();
  return json;
};

export const deleteBoard = async (token, selectedBoardId) => {
  const response = await fetch(
    `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
    { method: "DELETE", headers: { Authorization: token } }
  );
  const json = await response.json();
  return json;
};

export const createBoard = async (subject, content, file, token) => {
  // 파일 업로드를 위해 formData생성
  const formData = new FormData(); // javascript bulit-in 객체.
  formData.append("subject", subject);
  formData.append("content", content);
  formData.append("file", file);
  const response = await fetch("http://localhost:8080/api/v1/boards", {
    method: "POST",
    headers: { Authorization: token },
    body: formData,
  });
  const json = await response.json();
  return json;
};

export const modifyBoard = async (token, formData, selectedBoardId) => {
  const response = await fetch(
    `http://localhost:8080/api/v1/boards/${selectedBoardId}`,
    {
      method: "PUT",
      headers: { Authorization: token },
      body: formData,
    }
  );
  const json = await response.json();
  return json;
};
