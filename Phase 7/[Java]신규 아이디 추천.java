// <!-- ## https://school.programmers.co.kr/learn/courses/30/lessons/72410
// ## 풀이 순서
// ## 모두 소문자로 변환
// ## 쓸데없는 문자 제거
// ## .. -> . 으로 변환
// ## 시작, 끝의 . 을 제거
// ## 빈 문자열이면 a 넣기
// ## 16자 이상인경우 / 2자 이하인경우

// public class Solution {
//     public String solution(String new_id) {
//         ## 모두 소문자로 변환
//         new_id = new_id.toLowerCase();
        
//         ## 쓸데없는 문자 제거
//         new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
//         ## .. -> . 으로 변환
//         new_id = new_id.replaceAll("[.]{2,}", ".");
        
//         ## 시작, 끝의 . 을 제거
//         new_id = new_id.replaceAll("^[.]|[.]$", "");
        
//         ## 빈 문자열이면 a 넣기
//         if (new_id.isEmpty()) {
//             new_id = "a";
//         }
        
//         ## 16자 이상인경우, 앞의 15개의 문자를 제외한 나머지 문자들을 모두 제거
//         if (new_id.length() >= 16) {
//             new_id = new_id.substring(0, 15);
//             new_id = new_id.replaceAll("[.]$", "");
//         }
        
//         ## 2자 이하인경우, 마지막 문자를 아이디의 길이가 3이 될 때까지 끝에 붙이기
//         while (new_id.length() <= 2) {
//             new_id += new_id.charAt(new_id.length() - 1);
//         }
        
//         return new_id;
//     }
// }

// ## 다른사람의 풀이
// string solution(string new_id) {
//     for (char& ch : new_id) if ('A' <= ch && ch <= 'Z') ch |= 32;

//     string ret;
//     for (char& ch: new_id) {
//         if ('a' <= ch && ch <= 'z' ||
//             '0' <= ch && ch <= '9' ||
//             strchr("-_.", ch)) ret += ch;
//     }

//     new_id = ret;
//     ret.clear();
//     for (char& ch: new_id) {
//         if (!ret.empty() && ret.back() == '.' && ch == '.') continue;
//         ret += ch;
//     }

//     if (ret.front() == '.') ret.erase(ret.begin());
//     if (ret.back() == '.') ret.pop_back();

//     if (ret.empty()) ret = "a";
//     if (ret.size() >= 16) ret = ret.substr(0, 15);
//     if (ret.back() == '.') ret.pop_back();
//     while (ret.size() <= 2) ret += ret.back();

//     return ret;
// } -->
