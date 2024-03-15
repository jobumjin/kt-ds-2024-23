
window.onload = function() {

    var liElement = document.querySelectorAll("li");
    console.log(liElement);

    // 값이 여러개라 안됨..
    // var liText = liElement.innerText;
    // console.log(liText);

    // 반복을 하면서 가져와야한다...
    liElement.forEach(function(li) {
        console.log(li.innerText);
        li.innerText = "Seoul";
    });
}