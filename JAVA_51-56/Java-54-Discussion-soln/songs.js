let songs;
function init(){
  $.ajaxSetup({async: false});

  // Ensure Lesson_51_DBserver replit is running!
  let link = "http://localhost:8500";//replace with your Dev URL
  let route= "/songs";
  songs = $.getJSON(link+route).responseJSON;

  generateCards(songs);
}

function generateCards(songs){
  let centerpanel = document.getElementById("centerpanel");
  let build ="";

  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card" >`
    build += `<h4> ${song.Name} </h4>`;
    build += `<div> Album </div>`;
    build += `<span> ${song.Title} </span>`;
    build += `<div> Composer </div>`;
    build += `<span> ${song.Composer}</span>`;
    build += `</div>`;
  }
  // Now inject the build content into the output container
  centerpanel.innerHTML = build;
}

function filterByComposer(){
  let composer = document.getElementById("composer").value;  
  let newSongs = []; //create empty array

  for(let i=0; i<songs.length;i++){
    let song = songs[i]; //get each track

    if( song.Composer == composer) {
      //append to list
      newSongs.push(song);
    }
  }
  // Task 4: Generate the cards with your new array.
  generateCards(newSongs);  
}