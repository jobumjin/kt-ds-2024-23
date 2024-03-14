function sayHello() {
    console.log("반갑습니다.");
}

function sayHelloWithName(name) {
    console.log("안녕하세요." + name + "님!");
}

function calcNumbers(num1, num2) {
    var result = num1 + num2;
    return result;
}

// 정상 케이스
sayHello();
sayHelloWithName("범진");
var calcResult = calcNumbers(50, 40);
console.log(calcResult);

// 이상 케이스
sayHello(1,2,3,4,5);
sayHelloWithName();
var calcResult = calcNumbers(50, 40, 4, 5);
console.log(calcResult);

function addAllNumbers() {
    console.log(arguments);
    var sum = 0
    for (var i in arguments){
        sum += arguments[i]
    }
    return sum;
}
// 이렇게 할수는 있지만 파라미터 갯수를 맞춰주는 것이 좋다...
var addResult = addAllNumbers(1,2,3,4,5,135,1,3,53,15,315);
console.log(addResult);


// 중첩한다.
function getCalcNumbers(numberOne, numberTwo) {

    var result = calcPlus();
    // 숨기고 싶은 함수...
    function calcPlus() {
        return numberOne + numberTwo;
    }

    return result;

}
// 함수 안에 있는 중첩 함수는 호출 할 수 없다.
// getCalcNumbers()함수를 통해서만 실행될 수 있다.
// calcPlus(); // Uncaught ReferenceError: calcPlus is not defined

var result = getCalcNumbers(1, 2);
console.log(result);

// 콜백함수 (함수가 파라미터로 전달되는 함수)
function getCalcResult(num1, num2, beginFn, endFn) {
    // console.log("계산을 시작합니다.");
    // console.log(num1 + "+" + num2 + "계산을 시작합니다.");
    beginFn(num1, num2);
    var result = num1 + num2;
    // console.log("계산이 완료되었습니다.");
    // console.log("결과는 " + result + "입니다.");
    // console.log(num1 + " + " + num2 + " = " + result);
    endFn(num1, num2, result);
    return result;
}

var calcResult = getCalcResult(110, 220, function(num1, num2) {
    console.log("계산을 시작합니다.");
}, function(num1, num2, result) {
    console.log("계산이 완료되었습니다.");
    console.log("결과는 " + result + "입니다.");
});
console.log(calcResult);

var calcResult2 = getCalcResult(110, 220, function(num1, num2) {
    console.log("========================");
}, function(num1, num2, result) {
    console.log(num1 + " + " + num2 + " = " + result);
    console.log("========================");
});
console.log(calcResult2);

function counter() {
    var count = 0;
    return function() {
        return ++count;
    }
}



function counter2() {
    var count = 0;
    function count2() {
        return ++count;
    }
    return count2;
}

var counter1 = counter();
console.log(counter1);
var count = counter1;

console.log(count);
var count = counter1;
console.log(count);

var count = counter1;
console.log(count);

var counter2 = counter2();
console.log(counter2);
var count2 = counter2;
console.log(count2);

var count2 = counter2;
console.log(count2);

var count2 = counter2;
console.log(count2);

// 즉시 실행 함수.
(function(message) {
    console.log(message + "실행됨.");
})("즉시 실행 함수 ");


function foo() {
    var count = 0;
    if(true) {
        var bar =10;
    }
    console.log(count);
    console.log(bar);
}

foo();