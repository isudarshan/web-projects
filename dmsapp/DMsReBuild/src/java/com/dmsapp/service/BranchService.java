/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmsapp.service;

import com.dmsapp.domain.sub.Branch;
import java.util.List;

/**
 *
 * @author Sudarsan
 */
public interface BranchService {

   void create(Branch branch);
   
   List<Branch> getAll();
}
