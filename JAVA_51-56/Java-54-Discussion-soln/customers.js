let customers;

function init(){
  $.ajaxSetup({async: false});
  
  // Ensure Lesson_51_DBserver replit is running!
  let link = "http://localhost:8500";//replace with your Dev URL
  let route= "/customers";
  customers = $.getJSON(link+route).responseJSON;

  generateCards(customers);
}

function generateCards(customers){
  let centerpanel = document.getElementById("centerpanel");
  let build ="";

  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += `<div class="card" >`
    build +=   `<h3> Customer ID: ${customer.CustomerId}</h3>`;
    build +=   `<h4> ${customer.FirstName} ${customer.LastName}</h4>`;
    build +=   `<h5> ${customer.Phone}<br>`;
    build +=   `${customer.Email}</h5>`;
    build +=   `<hr>`;
    build +=   `<h5>${customer.City}, ${customer.Country}</h5>`;
    build += `<img src='countries/${customer.Country}.PNG'>`;
    build += `</div>`;    
  }
  // Now inject the build content into the output container
  centerpanel.innerHTML = build;
}

// filter by Country
function filterByCountry(){
  let country = document.getElementById("country").value;
  console.log(country);
  let customerList = []; //empty array

  for(let i=0; i<customers.length;i++){
    let customer = customers[i]; //get a customer
    //confirm country matches
    if( customer.Country == country ) {
          //append to list
          customerList.push(customer);
    }
  }
  generateCards(customerList);  
}
