// Create a webpage to search for employees by City.
// Your DB Server that serves the 'employees' route must be running!! (Lesson51 DBserver)

// Tasks 1 & 2 are in the index.html file
let employees;
function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8500"; //replace with your Dev URL
  let route= "/employees";
  employees = $.getJSON(link+route).responseJSON;

  generateCards(employees);  
}

function generateCards(employees){
  let output = document.getElementById("output");
  let build ="";
   
  for(let i=0; i<employees.length; i++){
    let employee = employees[i];
    build += `<div class="card" >`;
    build +=   `<h3> Employee ID : ${employee.EmployeeId}</h3>`;
    build +=   `<div> First Name : ${employee.FirstName}</div>`;
    build +=   `<div> Last Name : ${employee.LastName}</div>`;
    build +=   `<hr>`;
    build +=   `<p> City : ${employee.City}</p>`;    
    build += `</div>`;
  }
  console.log(`# of employees found: ${employees.length}`);
  output.innerHTML = build;  
}

// Task 3: Write the event handler function "filterByCity". 
// Your function should create a new empty array called 'newEmployees' to which you will add employees that match your specific filtering requirements.
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