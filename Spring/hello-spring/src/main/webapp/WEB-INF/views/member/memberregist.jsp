<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원가입</title>
    <style type="text/css">
      div.grid {
        display: grid;
        grid-template-columns: 120px 1fr;
        grid-template-rows: repeat(4, 28px) 1fr;
        row-gap: 10px;
      }
      div.grid > div.btn-group {
        grid-column: 1 / 3;
      }
      div.grid div.right-align {
        text-align: right;
      }
      label {
        padding-left: 10px;
      }
      button,
      input {
        padding: 10px;
      }
      input[type="file"] {
        padding: 0px;
      }
    </style>
    <script type="text/javascript">
      window.onload = function () {
        var dialog = document.querySelector(".alert-dialog");
        dialog.showModal();
      };
    </script>
  </head>
  <body>
    <c:if test="${not empty errorMessage}">
      <dialog class="alert-dialog">
        <h1>${errorMessage}</h1>
      </dialog>
    </c:if>
    <h1>회원가입</h1>
    <form method="post">
      <div class="grid">
        <label for="email">이메일</label>
        <input type="email" type="email" name="email" />

        <label for="name">이름</label>
        <input type="name" type="name" name="name" />

        <label for="password">비밀번호</label>
        <input type="password" type="password" name="password" />

        <label for="confirmPassword">비밀번호 확인</label>
        <input type="confirmPassword" type="password" name="confirmPassword" />

        <div class="btn-group">
          <div class="right-align">
            <input type="submit" value="등록" />
          </div>
        </div>
      </div>
    </form>
  </body>
</html>
