package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.BranchEntity;
import com.assignment.gocheeta.model.Branch;
import com.assignment.gocheeta.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
    private  BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository){
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch addBranch(Branch branch) {
        BranchEntity branchEntity = new BranchEntity();
        BeanUtils.copyProperties(branch, branchEntity);
        branchRepository.save(branchEntity);
        return branch;
    }

    @Override
    public List<Branch> getAllBranches() {
        List<BranchEntity> branchEntities = branchRepository.findAll();
        List<Branch> branches = branchEntities.stream().map(branch -> new Branch(branch.getId(),branch.getName())).collect(Collectors.toList());
               return branches;
    }

    @Override
    public Branch getBranchById(Long id) {
        BranchEntity branchEntity = branchRepository.findById(id).get();
        Branch branch = new Branch(branchEntity.getId(), branchEntity.getName());
        return branch;
    }

    @Override
    public boolean deleteBranch(Long id) {
        BranchEntity branchEntity = branchRepository.findById(id).get();
        branchRepository.delete(branchEntity);
        return true;
    }

    @Override
    public Branch updateBranch(Long id, Branch branch) {
        BranchEntity branchEntity = branchRepository.findById(id).get();
        branchEntity.setName(branch.getName());
        branchRepository.save(branchEntity);
        Branch updateBranch = new Branch(branchEntity.getId(), branchEntity.getName());
        return updateBranch;
    }

    
}
