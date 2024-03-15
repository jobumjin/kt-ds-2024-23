$().ready(function () {

    // .package-green-button 에게 클릭 이벤트를 할당.
    // $(".package-green-button").click(); // <-- 버튼을 클릭해라!

    // $(selector).click(callbackFunction); <-- Deprecated
    $(".package-green-button").on('click',function() {
        // p 태그 만들기
        var price = $("<p>$399.99</p>");

        // .package 내의 가장 아래쪽으로 붙이기
        $(".package").append(price);

        // .package-button-area 지우기
        $(".package-button-area").remove();
    }); // <-- 버튼을 클릭하면 function을 수행하라
});