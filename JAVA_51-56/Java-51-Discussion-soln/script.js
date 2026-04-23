// Your DB Server that serves the 'customers' route must be running!!  (Lesson51 DBserver)
let customers, cardCount, output; //global variables

async function init(){
  cardCount = document.getElementById("cardCount");
  output = document.getElementById("output");
  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/customers";

  info = await fetch(link+route);
  customers = await info.json();

  generateCards(customers);
}

// generate & display all customer cards
function generateCards(customers){   
  let build ="";
  let count = 0;
  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    build += `<div class="card">
                  <h3> Customer ID: ${customer.CustomerId}</h3>
                  <h4> ${customer.FirstName} ${customer.LastName}</h4>
                  <h5> ${customer.Phone}<br>
                  ${customer.Email}</h5>
                  <hr>
                  <h5>${customer.City}, ${customer.Country}</h5>
              </div>`;
    count++;
  }
  cardCount.innerHTML = `<h2>${count} customer(s) found</h2>`;
  
  // Inject the build content into the output container
  output.innerHTML = build;
}

// filter by Country
function filterByCountry(){
  let country = document.getElementById("country").value;
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

// filter by Country or City
function filterByCountryOrCity(){
  let country = document.getElementById("country1").value;
  let city = document.getElementById("city1").value;
  let customerList = [];

  for(let i=0; i<customers.length;i++){
    let customer = customers[i];
    
    if( customer.Country == country  || customer.City == city) {
          //append to list
          customerList.push(customer);
    }
  }
  generateCards(customerList);  
}

// filter by Country and City
function filterByCountryAndCity(){
  let country = document.getElementById("country2").value;
  let city = document.getElementById("city2").value;
  let customerList = [];

  for(let i=0; i<customers.length;i++){
    let customer = customers[i];
    
    if( customer.Country == country  && customer.City == city) {
          //append to list
          customerList.push(customer);
    }
  }
  generateCards(customerList);  
}