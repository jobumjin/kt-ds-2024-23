// 컴포넌트 만들기
/**
 * props : {title: "", color:"", onClick: function(){}
 */
export function Section({ title, color, onClick }) {
  //export : 컴포넌트를 다른곳에서 쓸수있도록 공개시키는 용도
  // Section 컴포넌트는 하나의 태그를 반환시킴

  //컴포넌트 스타일링하기  > props를 이용해서 객체 꾸미기 !
  // 1. 상수 만들기
  const sectionStyle = {
    //2. 주고싶은 스타일 주기
    backgroundColor: "#CCC",
    color: color, //props로 전달된 color 적어주기
  };

  /**
   * Tag 혹은 Component의 Attribute를 작성 할 때, 아래 규칙을 지켜야 한다.
   * 1. Attribute의 값이 문자열 : "" 로 작성한다
   * 2. Attribute의 값이 문자열이 아니라면 : { 값 } 로 작성
   * 3. Attribute의 값이 변수 or 상수 or 객체 or 함수 등이라면,
   *    {변수 or 상수 or 객체 or 함수} 로 작성한다
   *  (즉, 문자열이 아니라면 {}로 작성해야한다 = 인터폴레이션)
   */
  return (
    <section style={sectionStyle} onClick={onClick}>
      This is {title} Component.
    </section>
  );
}
