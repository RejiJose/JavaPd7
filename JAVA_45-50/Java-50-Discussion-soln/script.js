let cust_array, info;

async function init(){
  // JSON data retrieval process  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; 
  // The URL above must be running in a separate broswer tab. (Alternate use: http://localhost:8500 )
  let route= "/customers";

  info = await fetch(link+route);
  cust_array = await info.json();

  console.log(cust_array); // confirm data retrieval

  generateCards(cust_array);
}


function generateCards(customers){
  let output = document.getElementById("output");
  let build ="";

  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += `<div class="card" >
                <h4> Customer ID: ${customer.CustomerId}</h4>
                <hr>
                <p> ${customer.LastName}, ${customer.FirstName}</p>
                <h5> Tel: ${customer.Phone}</h5>
              </div>`;
  }

  // Now inject the build content into the output container
  output.innerHTML = build;  
}