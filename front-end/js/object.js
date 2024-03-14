// 객체 만들기
// 첫 번째 객체 ( 비어있는 객체 )
var emptyObject = {};
console.log(emptyObject);
console.dir(emptyObject);

// 두 번째 객체 ( 값이 있는 객체 )
var movieObject = {
    id: "mv-20230314-123456",
    title: "테스트 영화",
    minAge: 7,
    genre: ["액션","판타지","SF","스릴러"],
    actors: [
        {
            name: "조인성",
            role: "주연",
            charactername: "인성"
        },
        {
            name: "차태현",
            role: "조연",
            charactername: "태현"
        }
    ]
};
console.log(movieObject);
console.dir(movieObject);

// 영화의 이름만 출력.
var title = movieObject.title;
console.log(title);

// 영화의 아이디만 출력.
var movieId = movieObject.id;
console.log(movieId);

// 영화의 출연진들을 출력.
var actors = movieObject.actors;
console.log(actors);

// 영화의 출연진 중 첫 번째 배우만 출력.
var actor = movieObject.actors[0];
console.log(actor);

// 영화의 촬영국가를 출력.
var locationInfo = movieObject.location; // undefined
console.log(locationInfo);

movieObject.location = "한국";
var locationInfo = movieObject.location;
console.log(locationInfo);
