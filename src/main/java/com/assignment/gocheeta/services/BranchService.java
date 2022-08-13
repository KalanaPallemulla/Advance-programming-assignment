package com.assignment.gocheeta.services;

import java.util.List;

import com.assignment.gocheeta.model.Branch;

public interface BranchService {

    Branch addBranch(Branch branch);

    List<Branch> getAllBranches();

    Branch getBranchById(Long id);

    boolean deleteBranch(Long id);

    Branch updateBranch(Long id, Branch branch);

}
