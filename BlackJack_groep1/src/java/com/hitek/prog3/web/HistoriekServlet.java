package com.hitek.prog3.web;

import com.hitek.prog3.db.service.HistoriekService;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI
 */
public class HistoriekServlet extends HttpServlet {
/*
 * method doPost - opvragen van historiek van een bepaalde speler.
 * @param request, response
 */    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String naam =request.getParameter("naam");
        
            HistoriekService his = new HistoriekService();
            List<String> l = his.historiekWeergeven(naam);
            
            Iterator itarator = l.iterator();
                request.setAttribute("itarator", itarator);
            
            
             
        RequestDispatcher view = request.getRequestDispatcher("historiek.jsp");
         view.forward(request, response);
    }

}
