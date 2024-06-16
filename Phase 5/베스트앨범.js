// https://school.programmers.co.kr/learn/courses/30/lessons/42579
function solution(genres, plays) {
  const genreMap = new Map();
  const songMap = new Map();

  for (let i = 0; i < genres.length; i++) {
    const genre = genres[i];
    const play = plays[i];

    if (genreMap.has(genre)) {
      genreMap.set(genre, genreMap.get(genre) + play);
    } else {
      genreMap.set(genre, play);
    }

    if (songMap.has(genre)) {
      songMap.get(genre).push([i, play]);
    } else {
      songMap.set(genre, [[i, play]]);
    }
  }

  const sortedGenres = [...genreMap.entries()]
    .sort((a, b) => b[1] - a[1])
    .map((entry) => entry[0]);

  const answer = [];
  for (const genre of sortedGenres) {
    const songs = songMap.get(genre);

    songs.sort((a, b) => {
      if (a[1] === b[1]) {
        return a[0] - b[0];
      } else {
        return b[1] - a[1];
      }
    });

    const selectedSongs = songs.slice(0, 2);
    for (const song of selectedSongs) {
      answer.push(song[0]);
    }
  }

  return answer;
}
