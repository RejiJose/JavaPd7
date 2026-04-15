// Create a webpage to filter for specific Songs based on search criteria.
// Your DB Server that serves the 'songs' route must be running!! (Lesson51 DBserver)

// See index.html file first.
let songs, output, cardCount;

async function init(){
  output = document.getElementById("output");
  cardCount = document.getElementById("cardCount");
  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/songs";

  info = await fetch(link+route);
  songs = await info.json();

  generateCards(songs);
}

function generateCards(songs){  
  let build ="";
  let count = 0;
  //Update number of songs found
  cardCount.innerHTML=`Number of songs found: ${songs.length}`;
  
  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card" >`
    build += 	`<h4> ${song.Name} </h4>`;
    build += 	`<div> Album </div>`;
    build += 	`<span> ${song.Title} </span>`;
    build += 	`<div> Composer </div>`;
    build += 	`<span> ${song.Composer}</span>`;
    build += `</div>`;
    count++;
  }
  cardCount.innerHTML = `<h2>${count} track(s) found</h2>`;
  output.innerHTML = build;
}

/*
  Challenge 1:
  Write the event handler function "filter1" that searches 
  for songs by song name, album title or composer name. Then
  generate the cards using the generateCards() function provided.
*/
function filter1(){
  let track = document.getElementById("songname").value;
  let title = document.getElementById("title1").value;
  let composer = document.getElementById("composer1").value;

  let newSongs = []; //create empty array

  for(let i=0; i<songs.length;i++){
    let song = songs[i]; //get each track

    if( song.Name == track || song.Title == title || song.Composer == composer) {
          //append to list
          newSongs.push(song);
    }
  }
  // Task 4: Generate the cards with your new array.
  generateCards(newSongs);  
}

/*
  Challenge 2:
  Write the event handler function "filter2" that searches 
  for songs by album title AND composer name. Then
  generate the cards using the generateCards() function provided.
*/
function filter2(){
  let title = document.getElementById("title2").value;
  let composer = document.getElementById("composer2").value;

  let newSongs = []; //create empty array

  for(let i=0; i<songs.length;i++){
    let song = songs[i] //get each track

    if( song.Title == title && song.Composer == composer) {
          //append to list
          newSongs.push(song);
    }
  }
  // Task 4: Generate the cards with your new array.
  generateCards(newSongs); 
}