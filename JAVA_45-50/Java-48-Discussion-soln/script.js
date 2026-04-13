let data, info; // global variables

async function init(){
  // JSON data retrieval process  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; 
  // This URL must be running in a separate broswer tab.
  // (Alternateively, use http://localhost:8500 as link address)
  let route= "/customers";

  info = await fetch(link+route);
  data = await info.json();

  let customers = data;

  //First display the entire array to the console and examine the content
  console.log(customers);

  // Traverse the array of JSON and print customer JSON object; then display the customerID, first and last name.
  // for(let i=0; i<customers.length; i++){
  //   let customer = customers[i];    
  //   console.log(customer.CustomerId);
  //   console.log("First name: " + customer.FirstName);
  //   console.log("Last name:  " + customer.LastName);
  //   console.log("*********************");
  // }

}