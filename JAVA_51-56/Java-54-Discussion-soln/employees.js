let employees, info;

async function init(){
  // Ensure Lesson_51_DBserver replit is running!
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/employees";

  info = await fetch(link+route);
  employees = await info.json();

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
