/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.utils.service;

import com.asiapp.service.AppUserService;
import com.asiapp.service.DepartmentService;
import com.asiapp.service.FacultyMapService;
import com.asiapp.service.FacultyService;
import com.asiapp.service.FeedBackService;
import com.asiapp.service.StudentService;
import com.asiapp.service.SubjectService;
import com.asiapp.service.impl.AppUserServiceImpl;
import com.asiapp.service.impl.DepartmentServiceImpl;
import com.asiapp.service.impl.FacultyMapServiceImpl;
import com.asiapp.service.impl.FacultyServiceImpl;
import com.asiapp.service.impl.FeedBackServiceImpl;
import com.asiapp.service.impl.StudentServiceImpl;
import com.asiapp.service.impl.SubjectServiceImpl;

/**
 *
 * @author Sudarsan
 */
public class ServiceUtils {

    public static AppUserService getAppUserService() {
        return AppUserServiceImpl.getInstance();
    }

    public static DepartmentService getDepartmentService() {
        return DepartmentServiceImpl.getInstance();
    }

    public static SubjectService getSubjectService() {
        return SubjectServiceImpl.getInstance();
    }

    public static FacultyService getFacultyService() {
        return FacultyServiceImpl.getInstance();
    }

    public static FacultyMapService getFacultyMapService() {
        return FacultyMapServiceImpl.getInstance();
    }

    public static StudentService getStudentService() {
        return StudentServiceImpl.getInstance();
    }

    public static FeedBackService getFeedbackService() {
        return FeedBackServiceImpl.getInstance();
    }
}
