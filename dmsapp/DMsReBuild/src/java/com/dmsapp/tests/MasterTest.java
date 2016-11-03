/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmsapp.tests;

import com.dmsapp.domain.sub.Attendance;
import com.dmsapp.service.AttendanceService;
import com.dmsapp.utils.service.ServiceUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author Sudarsan
 */
public class MasterTest {

    private static Logger LOG = Logger.getLogger(MasterTest.class);

    public static void main(String args[]) {



        AttendanceService attendanceService = ServiceUtils.getAttendanceService();

        Attendance attendance = attendanceService.findById("1", "BA", "1", "INDIAN HISTORY AND CULTURE 700AD");

//        if (attendance == null) {
//            attendance = new Attendance();
//            attendance.setYear("1");
//            attendance.setBranch("BA");
//            attendance.setSemister("1");
//            attendance.setPaper("INDIAN HISTORY AND CULTURE 700AD");
//            attendance.setNumberOfWorkingDays("40");
//            attendanceService.create(attendance);
//        } else {
//            LOG.debug("In Update");
//            attendance.setId(attendance.getId());
//            attendance.setYear("1");
//            attendance.setBranch("BA");
//            attendance.setSemister("1");
//            attendance.setPaper("INDIAN HISTORY AND CULTURE 700AD");
//            attendance.setNumberOfWorkingDays("0");
//            attendanceService.create(attendance);
//        }

        LOG.debug(attendance);

    /*Attendance attendance = new Attendance();
    attendance.setId(1);
    attendance.setYear("1");
    attendance.setBranch("BA");
    attendance.setSemister(1);
    attendance.setPaper("INDIAN HISTORY AND CULTURE 700AD");
    attendance.setNumberOfWorkingDays("40");
    attendanceService.create(attendance);*/

//        MasterService masterService = ServiceUtils.getMasterService();
//        List<Master> masterList = masterService.findBy("2", "BA", 3);
//        Iterator<Master> iteratorMaster = masterList.iterator();
//        LOG.debug("Total Number of Papers"+masterList.size()+"\n");
//        LOG.debug("YEAR\tBRANCH\tSEM\tPAPER\n");
//        LOG.debug("==================================================\n\n");
//        while (iteratorMaster.hasNext()) {
//            Master master = iteratorMaster.next();
//            LOG.debug(master.getYear()+"\t"+master.getBranch() + "\t" + master.getSemister() + "\t" + master.getPaper());
//
//        }

//
//        TypeOneService marksService = ServiceUtils.getTypeOneService();
//
//        List<TypeOne> typeOneList = marksService.getMarks("1", "BA", "1", "INDIAN HISTORY AND CULTURE 700AD");
//
//
//        for(TypeOne one : typeOneList) {
//            LOG.debug(one.getFirstName()+"\t"+one.getPaper()+"\t"+one.getInterOneMarks());
//        }
    //TypeOne marks = marksService.checkStatus("111", "BA", "1", "1","INDIAN HISTORY AND CULTURE 700AD");

//
//       




    //LOG.debug(marks);




    }
}
