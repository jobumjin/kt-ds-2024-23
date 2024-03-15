window.onload = function () {
    
    // 버튼을 클릭했을때 이벤트
    var buttonArray = document.querySelectorAll(".package-green-button");
    
    buttonArray.forEach(function (button) {
        // click 이벤트 할당
        button.addEventListener("click", function() {
            // Element 생성.
            var price = document.createElement("p");
            price.innerText = "$399.99"
            console.log(price);

            // Element 추가.
            var package = button.parentElement.parentElement;
            package.append(price);

            // 버튼 제거
            var buttonArea = button.parentElement;
            buttonArea.remove();
        });
    });
    
    
}