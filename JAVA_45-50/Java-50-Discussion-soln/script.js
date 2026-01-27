let data;

function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8400";
  let route= "/customers";
  let cust_array = $.getJSON(link+route).responseJSON;

  generateCards(cust_array);

}

function generateCards(customers){
  let output = document.getElementById("output");
  let build ="";

  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += `<div class="card" >`
    build +=   `<h3> Customer ID: ${customer.CustomerId}</h3>`;
    build +=   `<hr>`;
    build +=   `<p> First Name: ${customer.FirstName}</p>`;
    build +=   `<div> Last Name: ${customer.LastName}</div>`;
    build +=   `<h5> Tel: ${customer.Phone}</h5>`;    
    build += `</div>`;
  }

  // Now inject the build content into the output container
  output.innerHTML = build;  
}