$().ready(function() {

    // id 가 destinations 인 엘리먼트 하위의
    // 모든 li 를 찾아온다.
    // CSS : "#destinations li" <--- 이 방법은 사용하면 안된다.. 느려서..
    var liInDestinations = $("#destinations").find("li"); // <-- 더 빠르다.
    
    console.log( liInDestinations );
    console.log( liInDestinations.text() );
    console.log( liInDestinations.html() );

    // liInDestinations.html("<div>Change!</div>")

    // CSS : "#destinations li:first-child"
    // $("#destinations li:first-child"); <--- 느리다.
    var firstLiElement = $("#destinations").find("li").first(); // <---- 빠르다.
    console.log("first li: ",firstLiElement.text());

    // CSS : "#destinations li:last-child"
    // $("#destinations li:last-child"); <--- 느리다.
    var lastLiElement = $("#destinations").find("li").last(); // <---- 빠르다.
    console.log("last li: ",lastLiElement.text());

    // CSS : "#destinations li:nth-child(2)"
    // $("#destinations li:nth-child(2)"); <--- 느리다.
    var secondLiElement = $("#destinations").find("li").first().next();
    console.log("second li: ", secondLiElement.text());

    // CSS : "#destinations li:nth-child(2)"
    // $("#destinations li:nth-child(2)"); <--- 느리다.
    var secondLiElement2 = $("#destinations").find("li").last().prev();
    console.log("second li: ", secondLiElement2.text());

    // $("#destinations").find("li").first();
    var firstLiElement2 = $("#destinations").find("li").eq(0);
    console.log("first li: ",firstLiElement2.text());
    
    // $("#destinations").find("li").first().next();
    var firstLiElement3 = $("#destinations").find("li").eq(1);
    console.log("second li: ",firstLiElement3.text());

    // $("#destinations").find("li").last();
    var lastLiElement2 = $("#destinations").find("li").eq(2);
    console.log("last li: ",lastLiElement2.text());

    var parentElement = $("li").parent(); // 사용 x (DOM의 구조가 상시로 바뀌기 때문에 )
    console.log(parentElement);
})