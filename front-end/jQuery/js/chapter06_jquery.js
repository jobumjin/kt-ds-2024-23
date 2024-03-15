$().ready(function() {

    $("img").on("mouseenter", function() {
        // $(".ticket").show();
        // $(".ticket").slideDown(200);
        $(".ticket").fadeIn();
    }).on("mouseleave", function() {
        // $(".ticket").hide();
        // $(".ticket").slideUp(200);
        $(".ticket").fadeOut();
    }).on("click", function() {
        console.log("이미지를 클릭함");
    }).on("contextmenu", function(event) {
        event.preventDefault();
        console.log("오른쪽 버튼을 클릭했습니다.");
    });


});