$().ready(function () {
  // 1. Input type text의 값을 가져오기
  var emailValue = $("#email").val();
  console.log(emailValue);

  // 2. Input type text의 값을 할당오기
  $("#email").val("jobumjin5500@gmail.com");

  // 3. Input type text의 값을 가져오기
  emailValue = $("#email").val();
  console.log(emailValue);

  //===================================
  // 1. jobs의 선택된 값을 가져오기
  var selectedJobs = $("#jobs").val(); // 0
  console.log(selectedJobs);

  // 2. jobs에서 값을 변경해서 다른 옵션을 선택하도록 하기
  $("#jobs").val("3"); // 화면에서 "교수"가 선택된 결과로 변화

  // 3. jobs의 선택된 값을 가져오기
  selectedJobs = $("#jobs").val();
  console.log(selectedJobs);

  // 4. jobs의 옵션이 바뀌었을 때 발생할 이벤트를 정의.
  $("#jobs").on("change", function () {
    var changeOptionValue = $(this).val();
    console.log(changeOptionValue);

    // === : 타입과 값이 일치할 떄만 true ==> "1" === 1 ==> False
    // == : 타입과 관계없이 값이 일치할 때 true ==> "1" === 1 ==> true
    // !== : === 의 반대
    // != : == 의 반대
    if (changeOptionValue === "0") {
      alert("직업을 반드시 선택해야 합니다!");
    } else if (changeOptionValue === "1") {
      alert("회사원을 선택했습니다.");
    } else if (changeOptionValue === "2") {
      alert("학생을 선택했습니다.");
    } else if (changeOptionValue === "3") {
      alert("교수을 선택했습니다.");
    } else {
      alert("올바른 직업을 선택해야합니다.");
    }
  });
  //   $("#jobs").val("999999");
  //   $("#jobs").change();

  //==================================
  var checkedAgeLength = $("input[type=radio][name=age]:checked").length;
  console.log(checkedAgeLength);
  if (checkedAgeLength === 0) {
    alert("나이대를 선택해주세요!");
  }

  var checkedAgeValue = $("input[type=radio][name=age]:checked").val();
  console.log("선택한 나이대는: " + checkedAgeValue);

  var checkedGenreLength = $(
    "input[type=Checkbox][name=favorate-genre]:checked"
  ).length;
  console.log(checkedGenreLength);
  if (checkedGenreLength === 0) {
    alert("좋아하는 장르를 1개 이상 선택해주세요!");
  }

  var checkedGenreValue = $(
    "input[type=Checkbox][name=favorate-genre]:checked"
  ).val();
  console.log("선택한 장르는: " + checkedGenreValue);

  $("#checked-all").on("change", function () {
    var isChecked = $(this).prop("checked");
    $("input[type=Checkbox][name=favorate-genre]").prop("checked", isChecked);
  });
  $("input[type=Checkbox][name=favorate-genre]").on("change", function () {
    var allCheckedLength = $(
      "input[type=Checkbox][name=favorate-genre]"
    ).length;
    var allCheckedboxLength = $(
      "input[type=Checkbox][name=favorate-genre]:checked"
    ).length;

    var isAllChecked = allCheckedLength === allCheckedboxLength;
    $("#checked-all").prop("checked", isAllChecked);
  });
});

/**
 * 모바일 기기에서 키보드의 레이아웃을 변경.
 * <input type="text"/>
 * <input type="number"/>
 * <input type="tel"/>
 * <input type="email"/>
 * <input type="..."/>
 */
