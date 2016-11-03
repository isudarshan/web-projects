/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asiapp.service;

import com.asiapp.domain.sub.Faculty;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface FacultyService extends Service{

    void create(Faculty faculty);

    List<Faculty> getAll();


}
