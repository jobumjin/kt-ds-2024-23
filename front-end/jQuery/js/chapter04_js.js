window.onload = function () {
    
    // 버튼을 클릭했을때 이벤트
    var button = document.querySelector(".package-green-button");
    // click 이벤트 할당
    button.addEventListener("click", function() {
        // Element 생성.
        var price = document.createElement("p");
        price.innerText = "$399.99"
        console.log(price);

        // Element 추가.
        var package = document.querySelector(".package");
        package.append(price);
        // package.prepend(price);
        // package.after(price);
        // package.before(price);

        // 버튼 제거
        var buttonArea = document.querySelector(".package-button-area");
        buttonArea.remove();
    });
}