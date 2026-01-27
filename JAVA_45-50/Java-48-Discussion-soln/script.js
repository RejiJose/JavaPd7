let data; // global variable

function init(){
  $.ajaxSetup({async: false}); // sets up data retrieval process to ensure all data is accessible.
  
  let link = "http://localhost:8500"; // This URL must be running in a separate broswer tab.
  let route= "/customers";
  let customers = $.getJSON(link+route).responseJSON;

  //First display the entire array to the console and examine the content
  //console.log(customers);

  // Traverse the array of JSON and print customer JSON object; then display the customer ID, first and last name.
  for(let i=0; i<customers.length; i++){
    let customer = customers[i];    
    console.log(customer.CustomerId);
    console.log("First name: " + customer.FirstName);
    console.log("Last name:  " + customer.LastName);
    console.log("*********************");
  }

}