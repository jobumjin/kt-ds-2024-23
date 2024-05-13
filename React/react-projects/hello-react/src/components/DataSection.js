// export function DataSection(props) {
//   const sectionStyle = {
//     //2. 주고싶은 스타일 주기
//     backgroundColor: "#CCC",
//     color: props.color, //props로 전달된 color 적어주기
//   };

//   return (
//     <section style={sectionStyle} onClick={props.onClick}>
//       {/** 여는 컴포넌트와 닫는 컴포넌트 사이에 작성된 내용이 children props로 전달된다. */}
//       {props.children}
//     </section>
//   );
// }

export function DataSection({ color, onClick, children }) {
  const sectionStyle = {
    backgroundColor: "#CCC",
    color: color,
  };

  return (
    <section style={sectionStyle} onClick={onClick}>
      {/** 여는 컴포넌트와 닫는 컴포넌트 사이에 작성된 내용이 children props로 전달된다. */}
      {children}
    </section>
  );
}
