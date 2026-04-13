let employees, info; // global variables

async function init(){  
  let link = "";// Insert your Dev URL from Activity 47. The activity (DB server) must be running in a separate tab.
  let route= "/employees";
  info = await fetch(link+route);
  employees = await info.json();

  /*
  For the problems below, use the DB server you created for Activity 47 and start it. 
  Make sure the link (forwarded Address from the "Port" tab in Codespaces) has been made PUBLIC.
  Install the "Live Server" extension. Right click your index.html file and choose 'Open with Live Server' to view the web page.
  */

  //Problem 1: Get the div with an id of 'output' which will be where you display your information.
  let output = "";
  let build = "";

  //Problem 2: For each employee display their ID, first name and last name by building a string of HTML. Don't forget to assign the string to the output div.

  


}