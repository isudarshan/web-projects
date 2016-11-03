/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bankapp.web.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmc9lab2
 */
public class RootServlet extends HttpServlet {

    @Override
    public final void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWork(request, response);
    }

    public void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
