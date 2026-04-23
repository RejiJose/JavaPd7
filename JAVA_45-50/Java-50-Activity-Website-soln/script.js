/* Goal for PART 2: Create a webpage that will display a card for each track(song) in the 'tracks' table from the Chinook database. (See picture "WebPagePicture.PNG").
For Part 1, see "Activity50_DBserver".
*/
let songs;

async function init(){
  // JSON data retrieval process  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; 
  // The URL above must be running in a separate broswer tab. (Alternate use: http://localhost:8500 )
  let route= "/songs";

  info = await fetch(link+route);
  songs = await info.json();
  console.log(songs); // confirm data retrieval

  // Invoke(call) function that creates the cards.
  generateCards(songs);
}

// Write a function that accepts an array of JSON that contains song information, generates an info card for each track(song) with song name, album title and composer. Display the cards on a webpage. (see "WebPagePicture.PNG" to determine the types of HTML elements to use).
function generateCards(songs){
  
  let output = document.getElementById("output");
  let build ="";
  
  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card" >
                  <h3> Song Name </h3>
                  <p> ${song.Name}</p>
                  <div> Album </div>
                  <h2> ${song.Title} </h2>
                  <div> Composer </div>
                  <h2> ${song.Composer}</h2>
                  <hr>
              </div>`;
  }
  // Inject the build content into the output container
  output.innerHTML = build;
}

// Add CSS rules to make the output div a flex container and provide appropriate styling for the card.