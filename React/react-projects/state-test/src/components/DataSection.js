export function DataSection({ textArray }) {
  // textArray의 형태
  // ["abc","def","abc","a","b"]
  // 변환
  // const divTags = [<div key="1">abc</div>,<div key="2">def</div>,<div key="3">abc</div>,<div key="4">b</div>,<div key="5">a</div>]
  return (
    <div>
      {textArray.map((text, index) => (
        <div key={index}>{text}</div>
      ))}
    </div>
  );
}
