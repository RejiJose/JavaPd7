let employees, info;

async function init(){
  // JSON data retrieval process  
  let link = ""; //replace with your specific link (Make it public)
  // The URL above must be running in a separate broswer tab. (Alternate use: http://localhost:8500 )
  let route= "/employees";

  info = await fetch(link+route);
  employees = await info.json();

  console.log(employees); // confirm data retrieval

  let output = ""
  let build = "";

  // Problem 1: Create a function that builds a card for each employee using the div with an id of 'output'. 
  // Make it a flex container using CSS. Each card should contain the employee ID, first name, last name, and title.


  // Problem 2: Add CSS Styling to style the info cards.
    


}