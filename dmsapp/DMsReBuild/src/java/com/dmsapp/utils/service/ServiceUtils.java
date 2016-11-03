
package com.dmsapp.utils.service;

import com.dmsapp.service.AttendanceService;
import com.dmsapp.service.BranchService;
import com.dmsapp.service.MarksMasterService;
import com.dmsapp.service.TypeOneService;
import com.dmsapp.service.MasterService;
import com.dmsapp.service.TypeTwoService;
import com.dmsapp.service.UpdateMarksService;
import com.dmsapp.service.impl.AttendanceServiceImpl;
import com.dmsapp.service.impl.BranchServiceImpl;
import com.dmsapp.service.impl.MarksMasterServiceImpl;
import com.dmsapp.service.impl.TypeOneServiceImpl;
import com.dmsapp.service.impl.MasterServiceImpl;
import com.dmsapp.service.impl.TypeTwoServiceImpl;
import com.dmsapp.service.impl.UpdateMarksServiceImpl;

/**
 *
 * @author Sudarsan
 */
public class ServiceUtils {

    public static MasterService getMasterService() {
        return MasterServiceImpl.getInstance();
    }

    public static BranchService getBranchService() {
        return BranchServiceImpl.getInstance();
    }

    public static TypeOneService getTypeOneService() {
        return TypeOneServiceImpl.getInstance();
    }

    public static TypeTwoService getTypeTwoService() {
        return TypeTwoServiceImpl.getInstance();
    }

    public static AttendanceService getAttendanceService() {
        return AttendanceServiceImpl.getInstance();
    }

    public static UpdateMarksService getUpdateMarksService() {
        return UpdateMarksServiceImpl.getInstance();
    }

    public static MarksMasterService getMarksMasterService() {
        return MarksMasterServiceImpl.getInstance();
    }
}
