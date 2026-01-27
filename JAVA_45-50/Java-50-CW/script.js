let employees;
function init(){
  $.ajaxSetup({async: false});
  
  let link = "";
  let route= ""
  let employees = $.getJSON(link+route).responseJSON;

  let output = ""
  let build ="";

  // Problem 1: Create a function that builds a card for each employee using the div with an id of 'output'. Make it a flex container using CSS. Each card should contain the employee ID, first name, last name, and title.


  // Problem 2: Add CSS Styling to style the info cards.
    


}