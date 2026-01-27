let data;// global variable

function init(){
  $.ajaxSetup({async: false});
  
  let link = "http://localhost:8500"; //use your URL from Activity 47 solution
  let route= "/customers";
  let customers = $.getJSON(link+route).responseJSON;
  console.log(customers);
  // 1) get the 'output' element
  let output = document.getElementById("output");
  let build ="";

  // Use string interpolation (use the backtick `` character)
  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += `<div class="card">
				 <h3> Customer ID : ${customer.CustomerId}</h3>
				 <p> First Name : ${customer.FirstName}</p>
				 <h5> Last Name : ${customer.LastName}</h5>
				 <p> Phone : ${customer.Phone}</p>
			</div>`;
  }

  // Now inject the build content into the output container
  output.innerHTML = build;

}