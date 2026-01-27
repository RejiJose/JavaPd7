let songs;

function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8500";
  let route= "/songs";
  songs = $.getJSON(link+route).responseJSON;

  generateCards(songs);
}

function generateCards(songs){
  let centerpanel = document.getElementById("mainpanel");
  let build ="";

  for(let i=0; i<songs.length; i++){
    let song = songs[i];
    build += `<div class="card" >`
    build += `<h3> ${song.Name} </h3>`;
    build += `<div> Album </div>`;
    build += `<span> ${song.Title} </span><hr>`;
    build += `<h4> Composer </h4>`;
    build += `<span> ${song.Composer}</span>`;
    build += `</div>`;
  }

  // Now inject the build content into the output container
  centerpanel.innerHTML = build;
}

function filter(){
  let comp = document.getElementById("composer").value;
  
  let newData = []; //create a list of songs searched for
  
  for(let i=0; i<songs.length;i++){
    let song = songs[i] //get each song
    //make sure the list is no
    if( song.Composer  == comp ) {
          //add to the new list
          newData.push(song);
       }
  }
  generateCards(newData);  
}