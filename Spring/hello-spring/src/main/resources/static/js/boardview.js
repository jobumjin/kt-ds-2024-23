$().ready(function () {
  $(".delete-board").on("click", function () {
    var chooseValue = confirm(
      "이 게시글을 정말 삭제하시겠습니까?\n삭제작업은 복구할 수 없습니다."
    );

    var id = $(this).closest(".grid").data("id");

    if (chooseValue) {
      location.href = "/board/delete/" + id;
    }
  });

  var modifyReply = function (event) {
    console.log("수정을 클릭함", event);
    var target = event.currentTarget;
    var reply = $(target).closest(".reply");
    var replyId = reply.data("reply-id");
    console.log("replyId", replyId);

    // 내용이 들어갈 곳을 찾아감.. pre 태그의 content 클래스를 가진 곳으로 간다.
    var content = reply.find(".content").text();
    // 그곳에 수정된 내용 가져와...
    $("#txt-reply").val(content);
    $("#txt-reply").focus();
    // 데이터 삽입
    $("#txt-reply").data("mode", "modify");
    $("#txt-reply").data("target", replyId);
  };

  var deleteReply = function (event) {
    console.log("삭제를 클릭함", event);
    var target = event.currentTarget;
    var reply = $(target).closest(".reply");
    var replyId = reply.data("reply-id");
    console.log("replyId", replyId);

    // 댓글 데이터 삭제
    $("#txt-reply").removeData("mode");
    $("#txt-reply").removeData("target");

    if (confirm("댓글을 삭제하시겠습니까?")) {
      $.get("/ajax/board/reply/delete/" + replyId, function (response) {
        var result = response.result;
        if (result) {
          loadReplies(boardId);
          $("#txt-reply").val("");
        }
      });
    }
  };

  var reReply = function (event) {
    console.log("댓글달기를 클릭함", event);
    var target = event.currentTarget;
    var reply = $(target).closest(".reply");
    var replyId = reply.data("reply-id");
    console.log("replyId", replyId);

    $("#txt-reply").data("mode", "re-reply");
    $("#txt-reply").data("target", replyId);
    $("#txt-reply").focus();
  };

  var recommendReply = function (event) {
    console.log("추천하기를 클릭함", event);
    var target = event.currentTarget;
    var reply = $(target).closest(".reply");
    var replyId = reply.data("reply-id");
    console.log("replyId", replyId);

    $.get("/ajax/board/reply/" + boardId, function (response) {
      var result = response.result;
      console.log(result);
      if (result) {
        loadReplies(boardId);
        $("#txt-reply").val("");
      }
    });
  };

  var loadReplies = function (boardId) {
    $(".reply-items").html("");

    $.get("/ajax/board/reply/" + boardId, function (response) {
      var count = response.data.count;
      var replies = response.data.replies;

      for (var i in replies) {
        var reply = replies[i];

        // <div class="reply" data-reply-id="댓글번호" style="padding-left: (level - 1) * 40px">
        var replyDom = $("<div></div>");
        replyDom.addClass("reply");
        replyDom.data("reply-id", reply.replyId);
        replyDom.css({
          "padding-left": (reply.level - 1) * 40 + "px",
        });

        //<div class="author">사용자명 (사용자이메일)</div>
        var authorDom = $("<div></div>");
        authorDom.addClass("author");
        authorDom.text(reply.memberVO.name + " (" + reply.email + ")");
        replyDom.append(authorDom);

        //<div class="recommend-count">추천수: 실제추천수</div>
        var recommendCountDom = $("<div></div>");
        recommendCountDom.addClass("recommend-count");
        recommendCountDom.text("추천수: " + reply.recommendCnt);
        replyDom.append(recommendCountDom);

        //<div class="datetime">
        var datetimeDom = $("<div></div>");
        datetimeDom.addClass("datetime");

        // <span class="crtdt">등록: 등록날짜</span>
        var crtdtDom = $("<span></span>");
        crtdtDom.addClass("crtdt");
        crtdtDom.text("등록: " + reply.crtDt);
        datetimeDom.append(crtdtDom);

        if (reply.crtDt !== reply.mdfyDt) {
          //<span class="mdfydt">(수정: 수정날짜)</span>
          var mdfydtDom = $("<span></span>");
          mdfydtDom.addClass("mdfydt");
          mdfydtDom.text("(수정: " + reply.mdfyDt + ")");
          datetimeDom.append(mdfydtDom);
        }
        replyDom.append(datetimeDom);

        //<pre class="content">댓글 내용</pre>
        var contentDom = $("<pre></pre>");
        contentDom.addClass("content");
        contentDom.text(reply.content);
        replyDom.append(contentDom);

        var loginEmail = $("#login-email").text();
        // <div>
        var controlDom = $("<div></div>");

        if (reply.email === loginEmail) {
          //<span class="modify-reply">수정</span>
          var modifyReplyDom = $("<span></span>");
          modifyReplyDom.addClass("modify-reply");
          modifyReplyDom.text("수정");
          modifyReplyDom.on("click", modifyReply);
          controlDom.append(modifyReplyDom);

          //<span class="delete-reply">삭제</span>
          var deleteReplyDom = $("<span></span>");
          deleteReplyDom.addClass("delete-reply");
          deleteReplyDom.text("삭제");
          deleteReplyDom.on("click", deleteReply);
          controlDom.append(deleteReplyDom);

          //<span class="re-reply">답변하기</span>
          var reReplyDom = $("<span></span>");
          reReplyDom.addClass("re-reply");
          reReplyDom.text("답변하기");
          reReplyDom.on("click", reReply);
          controlDom.append(reReplyDom);
        } else {
          //<span class="recommend-reply">추천하기</span>
          var recommendReplyDom = $("<span></span>");
          recommendReplyDom.addClass("recommend-reply");
          recommendReplyDom.text("추천하기");
          recommendReplyDom.on("click", recommendReply);
          controlDom.append(recommendReplyDom);

          // <span class="re-reply">답변하기</span>
          var reReplyDom = $("<span></span>");
          reReplyDom.addClass("re-reply");
          reReplyDom.text("답변하기");
          reReplyDom.on("click", reReply);
          controlDom.append(reReplyDom);
        }

        replyDom.append(controlDom);

        $(".reply-items").append(replyDom);
        /*
        <div class="reply" data-reply-id="댓글번호" style="padding-left: (level - 1) * 40px">
          <div class="author">사용자명 (사용자이메일)</div>
          <div class="recommend-count">추천수: 실제추천수</div>
          <div class="datetime">
            <span class="crtdt">등록: 등록날짜</span>
            <span class="mdfydt">(수정: 수정날짜)</span>
          </div>
          <pre class="content">댓글 내용</pre>
          <div>
            <span class="modify-reply">수정</span>
            <span class="delete-reply">삭제</span>
            <span class="re-reply">답변하기</span>

            <span class="recommend-reply">추천하기</span>
            <span class="re-reply">답변하기</span>
          </div>
        </div>;
        */
      }
    });
  };

  var boardId = $(".grid").data("id");
  loadReplies(boardId);

  $("#btn-save-reply").on("click", function () {
    $.post(
      "/ajax/board/reply/" + boardId,
      {
        content: $("#txt-reply").val(),
      },
      function (response) {
        var result = response.data.result;
        if (result) {
          loadReplies(boardId);
          $("#txt-reply").val("");
        } else {
          alert("댓글을 등록할 수 없습니다. 잠시 후 시도해주세요.");
        }
      }
    );

    var reply = $("#txt-reply").val();
    var mode = $("#txt-reply").data("mode");
    var target = $("#txt-reply").data("target");

    if (reply.trim() != "") {
      var body = { content: reply };
      var url = "/ajax/board/reply/" + boardId;
      if (mode == "re-reply") {
        body.parentReplyId = target;
      }

      if (mode == "modify") {
        url = "/ajax/board/reply/modify" + target;
      }
      $.post(url, body, function (response) {
        var result = response.result;
        if (result) {
          loadReplies();
          $("#txt-reply").val("");
        }
      });
    }
  });
  $("#btn-cancle-reply").on("click", function () {});
});
