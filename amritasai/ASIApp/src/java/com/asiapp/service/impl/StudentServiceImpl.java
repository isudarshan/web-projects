/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asiapp.service.impl;

import com.asiapp.domain.sub.Student;
import com.asiapp.domain.sub.Subject;
import com.asiapp.service.StudentService;
import com.asiapp.utils.hibernate.HibernateUtils;
import com.asiapp.utils.service.ServiceUtils;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sudarsan
 */
public class StudentServiceImpl extends ServiceImpl implements StudentService {

    private Logger LOG = Logger.getLogger(StudentServiceImpl.class);
    private static StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

    private StudentServiceImpl() {
    }

    public static StudentService getInstance() {
        return studentServiceImpl;
    }

    public List<Subject> getSubjects(String studentId) {
        List<Subject> subjects = null;

        try {
            Student student = findByStudentId(studentId);
            subjects = ServiceUtils.getSubjectService().find(student.getDepartmentName(), student.getYear(), student.getSemister());

        } catch (Exception exception) {
            LOG.debug("StudentServiceImpl", exception);
        }
        return subjects;
    }

    public Student findByStudentId(String studentId) {
        Student student = null;
        Session session = HibernateUtils.currentSession();

        try {

            Query query = session.createQuery("from Student student where student.studentId=:studentId");
            query.setParameter("studentId", studentId);
            student = (Student) query.uniqueResult();
        } catch (Exception exception) {

            LOG.debug("StudentServiceImpl", exception);
        } finally {
            HibernateUtils.closeSession();
        }
        return student;
    }

    public void create(Student student) {
        Session session = HibernateUtils.currentSession();
        Transaction tx = null;
        boolean rollback = true;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(student);
            tx.commit();
            rollback = false;
        } catch (Exception exception) {
            LOG.warn("StudentServiceImpl", exception);

        } finally {
            if (rollback && tx != null) {
                tx.rollback();
            }
            HibernateUtils.closeSession();
        }
    }
}
