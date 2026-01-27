import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import java.net.InetSocketAddress;
import java.util.Map;
/*
In order to communicate with the HTTP Webserver from a browser tab, you will need to append the route name to the Dev URL (copy url from Networking Tool within Replit)
OR 
In the browser address bar, type in http:// followed by your IP address, then a colon and the port #, followed by the route name
For e.g., http://192.168.0.100:8500/route_name
*/
public class Main {

    public static void main(String[] args) throws IOException {
    (new Main()).init();
  }

  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init() throws IOException {
   
    // Create a port - this is our Gateway
    int port = 8500;

    // Create the HTTPserver object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    // Start the server      
    server.start();
    System.out.println("Server is listening on port " + port); 

    //Problem 1: Create a default route that sends a string that has your name and states that this is your default route.
    server.createContext("/", new RouteHandler("My name is BLAH BLAH and this is my default route.") );

    //Problem 2: Create a route called myWebPage that serves(sends) the webpage stored in the file index.html. (You will need to read the file into a string first.)
    String html = Input.readFile("index.html");
    server.createContext("/myWebPage", new RouteHandler(html) );
          
  }    
}


