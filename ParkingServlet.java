package com.parking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parking.dao.ParkingDAO;
import com.parking.model.Parking;

@WebServlet("/ParkingServlet")
public class ParkingServlet extends HttpServlet {
    
    // Method to handle GET request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // Setting the response content type to HTML
        PrintWriter out = response.getWriter();

        // Creating ParkingDAO instance to fetch parking data
        ParkingDAO parkingDAO = new ParkingDAO();
        List<Parking> parkingList = parkingDAO.getAllBookings(); // Fetching all parking bookings

        // Generating HTML content to display the parking bookings
        out.println("<html><head><title>Parking Bookings</title></head><body>");
        out.println("<h1>List of Parking Bookings</h1>");
        out.println("<table border='1'><tr><th>ID</th><th>Parking ID</th><th>Location</th><th>Available Spots</th></tr>");
        
        // Iterating over the parking list and displaying each parking booking
        for (Parking parking : parkingList) {
            out.println("<tr><td>" + parking.getId() + "</td><td>" + parking.getParkingID() + "</td><td>" 
                        + parking.getLocation() + "</td><td>" + parking.getAvailableSpots() + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("</body></html>");
        out.close(); // Closing the PrintWriter
    }
}
