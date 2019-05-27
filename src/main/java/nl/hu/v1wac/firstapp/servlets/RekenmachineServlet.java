package nl.hu.v1wac.firstapp.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/RekenmachineServlet.do")
public class RekenmachineServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String getal1 = req.getParameter("getal1");
		String getal2 = req.getParameter("getal2");
		String methode = req.getParameter("calc");
		String resultaat = "";
		
		if (!getal1.equals("") && (!getal2.equals(""))){
			if (methode.equals("-")) {
				resultaat = "" + (Double.parseDouble(getal1) - Double.parseDouble(getal2));
			} else if (methode.equals("+")) {
				resultaat = "" + (Double.parseDouble(getal1) + Double.parseDouble(getal2));
			} else if (methode.equals("/")) {
				resultaat = "" + (Double.parseDouble(getal1) / Double.parseDouble(getal2));
			} else {
				resultaat = "" + (Double.parseDouble(getal1) * Double.parseDouble(getal2));
			}
		} else {
			getal1 = "niks";
			getal2 = "niks";
			resultaat = "niks";
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("  <title>Rekenmachine</title>");
		out.println("  <body>");
		out.println("    <h2>Rekenmachine</h2>");
		out.println( getal1 + " " + methode + getal2 + " is: " + resultaat);
		out.println("  </body>");
		out.println("</html>");
	}
}
