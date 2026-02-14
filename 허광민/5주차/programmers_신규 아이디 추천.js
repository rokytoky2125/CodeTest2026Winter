function solution(new_id) {
  // 1단계: 소문자로 치환
  new_id = new_id.toLowerCase();

  // 2단계: 특수문자 제거
  new_id = new_id.replace(/[~!@#$%^&*()=+[{\]}:?,<>\/]/g, '');

  // 3단계 ..., ..을 .으로 치환
  while (new_id.includes('..')) {
    new_id = new_id.replace('..', '.');
  }

  // 4단계: 처음 또는 끝에 위치한 . 제거
  new_id = new_id.replace(/^\.+|\.+$/g, '');

  // 5단계: 빈 문자열이면 'a' 추가
  if (new_id.length === 0) new_id += 'a';

  // 6단계: 16자 이상이면 15자 이후의 문자 모두 제거
  if (new_id.length >= 16) {
    new_id = new_id.slice(0, 15);
    new_id = new_id.replace(/\.+$/, '');
  }

  // 7단계: 2자 이하이면 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
  if (new_id.length <= 2) {
    while (new_id.length <= 2) {
      new_id += new_id.slice(-1);
    }
  }

  return new_id;
}
