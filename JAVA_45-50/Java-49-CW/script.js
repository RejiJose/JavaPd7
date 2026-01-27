let employees;

function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8500";
  let route= "/employees";
  let employees = $.getJSON(link+route).responseJSON;

  //Problem 1: Get the div with an id of 'output' which will be where you display your information.
  let output = "";
  let build ="";
  //Problem 2: For each employee display their ID, first name and last name by building a string of HTML. Don't forget to assign the string to the output div.

  


}