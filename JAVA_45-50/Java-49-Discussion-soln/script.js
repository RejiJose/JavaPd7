let data, info;// global variables

async function init(){
  // JSON data retrieval process  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; 
  // The URL above must be running in a separate broswer tab. (Alternate use: http://localhost:8500 )
  let route= "/customers";

  info = await fetch(link+route);
  data = await info.json();

  let customers = data;
  console.log(customers); // confirm data retrieval

  // 1) get the 'output' element and initialize the 'build' variable
  let output = document.getElementById("output");
  let build ="";

  // 2) Use string interpolation (use the backtick `` character)
  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += `<div class="card">
				 <h3> Customer ID : ${customer.CustomerId}</h3>
				 <p> First Name : ${customer.FirstName}</p>
				 <h5> Last Name : ${customer.LastName}</h5>
				 <p> Phone : ${customer.Phone}</p>
			</div>`;
  }

  // 3) Inject the build content into the output container
  output.innerHTML = build;

}