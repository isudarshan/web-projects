/**
 *
 */
package com.appcmc.web.controller;

import com.appcmc.context.id.names.ContextIdNames;
import com.appcmc.domain.sub.AppUser;
import com.appcmc.domain.sub.Contacts;
import com.appcmc.domain.sub.EducationalQualifications;
import com.appcmc.domain.sub.Student;
import com.appcmc.domain.sub.StudentProfile;
import com.appcmc.service.AppMailService;
import com.appcmc.service.AppUserService;
import com.appcmc.service.EducationalQualificationsService;
import com.appcmc.service.StudentProfileService;
import com.appcmc.service.StudentService;
import com.appcmc.utils.AppContext;
import com.appcmc.web.forms.ChangePasswordForm;
import com.appcmc.web.forms.EnrollmentForm;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Sudarsan
 *
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    private Logger LOG = Logger.getLogger(MasterController.class);
    private StudentService studentService = null;
    private AppUserService appUserService = null;
    private EducationalQualificationsService educationalQualificationsService = null;
    private Student student = null;
    private StudentProfile studentProfile = null;
    private Contacts contacts = null;
    private AppUser appUser = null;
    private InputStream inputStream = null;
    private EducationalQualifications educationalQualifications = null;
    StudentProfileService studentProfileService = null;
    private AppMailService appMailService = null;
    private Date date = null;

    @RequestMapping(method = RequestMethod.GET)
    public String showMaster(@ModelAttribute EnrollmentForm enrollmentForm, ChangePasswordForm changePasswordForm, WebRequest request) {

        studentService = (StudentService) AppContext.APPCONTEXT.getBean(ContextIdNames.STUDENT_SERVICE);
        List<Student> studentList = studentService.getAll();
        List<Student> studentMonthlyEnrollment = studentService.getByCurrentMonth();
        List<Student> studentWeeklyEnrollment = studentService.getByCurrentWeek();
        List<Student> studentDayEnrollment = studentService.getByDay();
        request.setAttribute("studentCount", studentList.size(), WebRequest.SCOPE_REQUEST);
        request.setAttribute("studentWeeklyCount", studentWeeklyEnrollment.size(), WebRequest.SCOPE_REQUEST);
        request.setAttribute("StudentMonthlyCount", studentMonthlyEnrollment.size(), WebRequest.SCOPE_REQUEST);
        request.setAttribute("studentDayCount", studentDayEnrollment.size(), WebRequest.SCOPE_REQUEST);

        return "/master/masterHome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/showEnrollment")
    public String showEnrollment(@ModelAttribute EnrollmentForm enrollmentForm, ChangePasswordForm changePasswordForm) {
        return "/master/enrlHome";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String doEnrollment(@ModelAttribute EnrollmentForm enrollmentForm, HttpServletRequest request) {

        studentService = (StudentService) AppContext.APPCONTEXT
                .getBean(ContextIdNames.STUDENT_SERVICE);
        appUserService = (AppUserService) AppContext.APPCONTEXT
                .getBean(ContextIdNames.APP_USER_SERVICE);
        educationalQualifications = (EducationalQualifications) AppContext.APPCONTEXT
                .getBean(ContextIdNames.EDUCATIONAL_QUALIFICATIONS);
        student = (Student) AppContext.APPCONTEXT
                .getBean(ContextIdNames.STUDENT);

        // Creating Contact Details
        contacts = (Contacts) AppContext.APPCONTEXT
                .getBean(ContextIdNames.CONTACTS);

        // Creating a Student
        student.setEnrollmentNumber(enrollmentForm.getEnrollmentNumber());
        student.setEmail(enrollmentForm.getEmail());
        student.setFirstName(enrollmentForm.getFirstName());
        student.setLastName(enrollmentForm.getLastName());

        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) AppContext.APPCONTEXT.getBean(ContextIdNames.SIMPLE_DATE_FORMAT);
        try {
            Date dateOfBirth = simpleDateFormat.parse(enrollmentForm.getDateOfBirth());
            student.setDateOfBirth(dateOfBirth);
        } catch (ParseException e) {
            LOG.warn("STUDENT TEST", e);
        }
        date = (Date) AppContext.APPCONTEXT.getBean(ContextIdNames.DATE);
        student.setGender(enrollmentForm.getGender());
        student.setNationality(enrollmentForm.getNationality());
        student.setCategory(enrollmentForm.getCategorey());
        student.setMaritalStatus(enrollmentForm.getStatus());
        student.setFatherName(enrollmentForm.getFatherName());
        student.setMotherName(enrollmentForm.getMotherName());
        student.setOccupation(enrollmentForm.getOcupation());
        student.setIncome(enrollmentForm.getAnnualIncome());

        contacts.setEnrollmentNumber(student.getEnrollmentNumber());
        contacts.setCity(enrollmentForm.getCity());
        contacts.setState(enrollmentForm.getState());
        contacts.setCountry(enrollmentForm.getCountry());
        contacts.setEmail(student.getEmail());
        contacts.setAlternativeEmail(enrollmentForm.getAletrnativeEmail());
        contacts.setMobile(enrollmentForm.getMobile());
        contacts.setLandPhone(enrollmentForm.getLandPhone());
        contacts.setPinCode(enrollmentForm.getPinCode());
        contacts.setAddress(enrollmentForm.getAddress());
        contacts.setCreatedOn(date);
        contacts.setCreatedBy(1L);
        contacts.setModifiedOn(date);
        contacts.setModifiedBy(1L);
        contacts.setActive(new Short("1"));

        String fileName = request.getSession().getServletContext().getRealPath("/resources/images/content/user-img-40.jpg");
        byte[] imageBytes = null;
        try {
            inputStream = new FileInputStream(fileName);
            imageBytes = new byte[inputStream.available()];
            inputStream.read(imageBytes);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MasterController.class.getName()).log(Level.SEVERE, null, ex);
        }

        student.setContacts(contacts);
        student.setProfilePic(imageBytes);
        student.setCreatedOn(date);
        student.setCreatedBy(1L);
        student.setModifiedOn(date);
        student.setModifiedBy(1L);
        student.setActive(new Short("1"));
        studentService.create(student);

        // Creating Application User
        appUser = (AppUser) AppContext.APPCONTEXT
                .getBean(ContextIdNames.APP_USER);
        appUser.setEmail(student.getEmail());
        appUser.setEnrollmentNumber(student.getEnrollmentNumber());
        appUser.setPassword("default");
        appUser.setScreenName(student.getFirstName());
        appUser.setFirstName(student.getFirstName());
        appUser.setLastName(student.getLastName());
        appUser.setStatusId(1L);
        appUser.setGender(student.getGender());
        appUser.setTimeZone("timeZone");
        appUser.setType("student");
        appUser.setCreatedOn(date);
        appUser.setCreatedBy(1L);
        appUser.setModifiedOn(date);
        appUser.setModifiedBy(1L);
        appUser.setActive(new Short("1"));
        appUserService.create(appUser);

        educationalQualifications.setEnrollmentNumber(enrollmentForm.getEnrollmentNumber());
        educationalQualifications.setActive(new Short("1"));
        educationalQualifications.setAdditionalQualification("Not filled");
        educationalQualifications.setCreatedBy(1L);
        educationalQualifications.setCreatedOn(date);
        educationalQualifications.setFourGrade("Not Available");
        educationalQualifications.setFourQualification("Not Available");
        educationalQualifications.setFourSpecialization("Not Available");
        educationalQualifications.setFourUniversity("Not Available");
        educationalQualifications.setFourYearOfPass("Not Available");
        educationalQualifications.setModifiedBy(1L);
        educationalQualifications.setModifiedOn(date);
        educationalQualifications.setOneGrade("Not Available");
        educationalQualifications.setOneQualification("Not Available");
        educationalQualifications.setOneUniversity("Not Available");
        educationalQualifications.setOneYearOfPass("Not Available");
        educationalQualifications.setThreeGrade("Not Available");
        educationalQualifications.setThreeQualification("Not Available");
        educationalQualifications.setThreeSpecialization("Not Available");
        educationalQualifications.setThreeUniversity("Not Available");
        educationalQualifications.setThreeYearOfPass("Not Available");
        educationalQualifications.setTwoGrade("Not Available");
        educationalQualifications.setTwoQualification("Not Available");
        educationalQualifications.setTwoSpecialization("Not Available");
        educationalQualifications.setTwoUniversity("Not Available");
        educationalQualifications.setTwoYearOfPass("Not Available");
        educationalQualificationsService = (EducationalQualificationsService) AppContext.APPCONTEXT.getBean(ContextIdNames.EDUCATIONAL_QUALIFICATIONS_SERVICE);
        educationalQualificationsService.create(educationalQualifications);

        studentProfile = (StudentProfile) AppContext.APPCONTEXT.getBean(ContextIdNames.STUDENT_PROFILE);
        studentProfile.setActive(new Short("1"));
        studentProfile.setCreatedBy(1L);
        studentProfile.setCreatedOn(date);
        studentProfile.setCurrentEmployer("Not Updated");
        studentProfile.setEnrollmentNumber(enrollmentForm.getEnrollmentNumber());
        studentProfile.setKeySkills("Not Updated");
        studentProfile.setModifiedBy(1L);
        studentProfile.setModifiedOn(date);
        studentProfile.setPreviousEmployer("Not Updated");
        studentProfile.setRole("Not Updated");
        studentProfile.setTitle("Not Updated");
        studentProfile.setTotalExperience("Not Updated");
        studentProfile.setResume(null);
        studentProfileService = (StudentProfileService) AppContext.APPCONTEXT.getBean(ContextIdNames.STUDENT_PROFILE_SERVICE);
        studentProfileService.create(studentProfile);

        //Sending EnrollmentNumber  to the Student through java mail
        appMailService = (AppMailService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_MAIL_SERVICE);
        String image1 = request.getSession().getServletContext().getRealPath("resources/images/bluefade_left.gif");
        String image2 = request.getSession().getServletContext().getRealPath("resources/images/bluefade_right.gif");
        String image3 = request.getSession().getServletContext().getRealPath("resources/images/CMC_LOGO.jpg");
        String image4 = request.getSession().getServletContext().getRealPath("resources/images/mockimage.gif");
        
        
        LOG.debug("==============Image4"+image4.length());
        List<String> imageList = new ArrayList<String>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        imageList.add(image4);
        

        try {
            appMailService.sendMail(appUser, imageList);
            return "success";
        } catch (Exception exception) {
            LOG.debug("MasterController", exception);
            return "failure";
        }

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/changePassword")
    public String changePasswordAction(@ModelAttribute ChangePasswordForm changePasswordForm) {

        String userName = changePasswordForm.getUserName();
        String currentPassword = changePasswordForm.getCurrentPassword();
        String newPassword = changePasswordForm.getNewPassword();

        appUserService = (AppUserService) AppContext.APPCONTEXT.getBean(ContextIdNames.APP_USER_SERVICE);
        appUser = appUserService.authenticate(userName, currentPassword);
        if (appUser == null) {
            // TO DO
            LOG.debug("===============User Not Available");
            return "fail";
        }
        date = (Date) AppContext.APPCONTEXT.getBean(ContextIdNames.DATE);
        appUser.setId(appUser.getId());
        appUser.setGuid(appUser.getGuid());
        appUser.setEmail(appUser.getEmail());
        appUser.setEnrollmentNumber(userName);
        appUser.setPassword(newPassword);
        appUser.setScreenName(appUser.getScreenName());
        appUser.setFirstName(appUser.getFirstName());
        appUser.setLastName(appUser.getLastName());
        appUser.setStatusId(appUser.getStatusId());
        appUser.setGender(appUser.getGender());
        appUser.setTimeZone(appUser.getTimeZone());
        appUser.setType(appUser.getType());
        appUser.setCreatedOn(appUser.getCreatedOn());
        appUser.setCreatedBy(appUser.getCreatedBy());
        appUser.setModifiedOn(date);
        appUser.setActive(appUser.getActive());
        appUserService.create(appUser);

        return "success";
    }
}