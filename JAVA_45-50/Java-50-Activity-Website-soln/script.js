/* GOAL: To create a webpage that will display a card for each track(song) in the 'tracks' table from the Chinook database. (See picture "WebPagePicture.PNG").

For Part 1, see the Activity50_DBserver Replit
*/
let data,songs;

function init(){
  $.ajaxSetup({async: false});

  // PART 2: Create the webpage. 
  // Get data from DB server and store in variable.  
  let link = "http://localhost:8500";
  let route= "/songs";
  songs = $.getJSON(link+route).responseJSON;
  
  // Invoke(call) function that creates the cards.
  generateCards(songs);
}

// Write a function that accepts an array of JSON that contains song information, generates an info card for each track(song) and displays them on the webpage. (see "WebPagePicture.PNG" to determine the types of HTML elements to use).
function generateCards(songs){
  
  let output = document.getElementById("output");
  let build ="";
  
  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card" >`;
    build += `<h3> Song Name </h3>`;
    build += `<p> ${song.Name}</p>`;
    build += `<div> Album </div>`;
    build += `<h2> ${song.Title} </h2>`;
    build += `<div> Composer </div>`;
    build += `<h2> ${song.Composer}</h2>`;
    build += `<hr>`;
    build += `</div>`;
  }
  // Inject the build content into the output container
  output.innerHTML = build;
}

// Add CSS rules to make the output div a flex container and provide appropriate styling for the card.