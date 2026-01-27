let employees;

function init(){
  $.ajaxSetup({async: false});
  
  // Ensure Lesson_51_DBserver replit is running!
  let link = "http://localhost:8500";//replace with your Dev URL
  let route= "/employees";
  employees = $.getJSON(link+route).responseJSON;

  generateCards(employees);
}

function generateCards(employees){
  let centerpanel = document.getElementById("centerpanel");
  let build ="";

  for(let i=0; i<employees.length; i++){
    let employee = employees[i];
    build += `<div class="card" >`
    build +=   `<h3> Employee ID: ${employee.EmployeeId}</h3>`;
    build +=   `<div> First Name: ${employee.FirstName}</div>`;
    build +=   `<div> Last Name: ${employee.LastName}</div>`;
    build +=   `<hr>`;
    build +=   `<p> City: ${employee.City}</p>`;    
    build += `</div>`;
  }
  console.log(`# of employees found: ${employees.length}`);
  centerpanel.innerHTML = build; 
}

function filterByCity(){
  let city = document.getElementById("city").value;
  console.log(city);

  let newEmployees = []; //create empty array

  for(let i=0; i<employees.length;i++){
    let employee = employees[i] //get each employee

    if( employee.City == city ) {
          //append to list
          newEmployees.push(employee);
       }
  }
  console.log(`# of employees found: ${newEmployees.length}`);
  // Task 4: Generate the cards with your new array.
  generateCards(newEmployees);  
}
