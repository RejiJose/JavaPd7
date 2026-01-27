// Create a webpage to filter for specific Songs based on search criteria.
// Your DB Server that serves the 'songs' route must be running!! (Lesson51 DBserver)

// See index.html file first.
let songs;
function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8500"; //replace with your Dev URL
  let route= "/songs";
  songs = $.getJSON(link+route).responseJSON;

  generateCards(songs);
}

function generateCards(songs){
  let output = document.getElementById("output");
  let count = document.getElementById("count");
  let build ="";
  //Update number of songs found
  count.innerHTML=`Number of songs found: ${songs.length}`;
  
  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card" >`
    build += 	`<h4> ${song.Name} </h4>`;
    build += 	`<div> Album </div>`;
    build += 	`<span> ${song.Title} </span>`;
    build += 	`<div> Composer </div>`;
    build += 	`<span> ${song.Composer}</span>`;
    build += `</div>`;
  }
  
  output.innerHTML = build;
}

/*
  Challenge 1:
  Write the event handler function "filter1" that searches 
  for songs by song name, album title or composer name. Then
  generate the cards using the generateCards() function provided.
*/



/*
  Challenge 2:
  Write the event handler function "filter2" that searches 
  for songs by album title AND composer name. Then
  generate the cards using the generateCards() function provided.
*/
