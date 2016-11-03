/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.web.controller;

import com.hms.domain.sub.LabAdmin;
import com.hms.service.LabAdminService;
import com.hms.utils.ServiceUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmc
 */
public class LabAdminImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");

        String firstName = request.getParameter("firstName").trim();

        LabAdminService adminService = ServiceUtils.getLabAdminService();
        List<LabAdmin> admin = adminService.getByUserName(firstName);
        System.out.println(firstName);

        byte[] imageBytes = null;
        for (int i = 0; i < admin.size(); i++) {

            LabAdmin admin1 = admin.get(i);
            imageBytes = admin1.getPhoto();
            response.setContentLength(imageBytes.length);

        }

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(imageBytes);

        outputStream.flush();
        outputStream.close();
    }
}
