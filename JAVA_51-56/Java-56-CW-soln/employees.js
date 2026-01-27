/*
Problem 2:  For each employee, create a Modal card where the text of the card has the employee id, first and last name. As the Modal content, include the city and the flag of the city.
*/

// Ensure Lesson_51_DBserver replit is running!
let employees;
function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8500";//replace with your Dev URL
  let route= "/employees";
  employees = $.getJSON(link+route).responseJSON;

  generateCards(employees);  
}

function generateCards(employees){
  // Display info as a Modal
  let mainpanel = document.getElementById("centerpanel");
  mainpanel.innerHTML = ""; //clear out the container

  // initialize strings for modal text and HTML content
  let text ="";
  let content ="";
   
  for(let i=0; i<employees.length; i++){
    let employee = employees[i]
    // create HTML for Modal text
    text  = `<div class="card" >`
    text += `<h3> Employee ID : ${employee.EmployeeId}</h3>`;
    text += `<div> First Name : ${employee.FirstName}</div>`;
    text += `<div> Last Name : ${employee.LastName}</div>`;
    text += `<hr>`;
    text += `</div>`;
    // create HTML for Modal content
    content  = `<div class="card" >`
    content += `<p> City : ${employee.City}</p>`;
    content += `<img src="cities/${employee.City}.PNG">`;
    content += `<hr>`;
    content += `</div>`;
     // create Modal object while passing text & content
    let modal = new Modal(text,content);
    modal.render("centerpanel"); // render Modal in container
  }  
}

function filter(){
  let city = document.getElementById("city").value;
  console.log(city);

  let newEmployees = []; //create a list to add employees to
  
  for(let i=0; i<employees.length;i++){
    let employee = employees[i] //get each employee
    
    if( employee.City == city ) {
          //add to the list
          newEmployees.push(employee);
    }
  }
  
  console.log(`number found ${newEmployees.length}`)
  generateCards(newEmployees);  
}