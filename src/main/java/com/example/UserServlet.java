package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    // Simulated API key for this example
    private static final String VALID_API_KEY = "d18d87ba-7baa-4954-bfe0-a89eb2c32b01"; 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        // Get the API key from the request header
        String apiKey = request.getHeader("API-Key");
        
        // Check if the API key matches
        if (VALID_API_KEY.equals(apiKey)) {
            // Process the request for authorized access
            response.getWriter().write("This is a private path, and you have access!");
        } else {
            // Unauthorized access
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized. Invalid or missing API Key.");
        }
    }
}
