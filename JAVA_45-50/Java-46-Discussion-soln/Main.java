import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

import java.net.InetSocketAddress;
import java.util.Map;
/*
To communicate with DB server: In browser, append route name to the Port forwarded address
(ctrl + click link in Codespace Port tab)
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
   
    // 1. Create a port - this is our Gateway
    int port = 8001;
      
    // 2. Create the HTTP Server object
    HttpServer server = HttpServer.create(new InetSocketAddress(port),0);

    // 3. Start the server      
    server.start();
    System.out.println("Server is listening on port " + port);     

    
    // 4. Create a Route Handler to respond to the request
    // this is our default route
    server.createContext("/", new RouteHandler("Hi there. This is my default route...") );
    
    // 4a) create a route named 'myPage1'
    String html = "<html><body><marquee><h1>Here's my 1ST Webpage !!</h1></marquee>";
	  html +="<h3>Info that scrolls is a Marquee element</h3></body></html>"; 
    server.createContext("/myPage1", new RouteHandler(html) );
    
    // 4b) create a route named 'myPage2'
    html = "<html><body>";
    html +=		"<marquee>";
    html +=			"<h1>This is my 2ND Webpage.</h1><br>";
    html +=			"<img src='https://cdn.pixabay.com/photo/2019/02/19/19/45/thumbs-up-4007573_960_720.png'>"; 
    html +=			"<h3>This page has a picture</h3>";
    html +=		"</marquee>";
    html +="</body></html>";	
    server.createContext("/myPage2", new RouteHandler(html) );
	// Note: only use external image sources
    
     // 4c) create a route named 'myPage3'
    html = Input.readFile("index1.html");// reads file and returns a string
    server.createContext("/myPage3", new RouteHandler(html) );

    // 4d) create a route named 'myPage4'
    html = Input.readFile("index2.html");
    server.createContext("/myPage4", new RouteHandler(html) );  
      
  }    
}


