package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.Branch;
import com.assignment.gocheeta.entity.User;
import com.assignment.gocheeta.repository.BranchRepository;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class BranchServiceImpl implements BranchService {
    private  BranchRepository branchRepository;
    private UserRepository userRepository;

    public BranchServiceImpl(BranchRepository branchRepository, UserRepository userRepository) {
        this.branchRepository = branchRepository;
        this.userRepository = userRepository;
    }

    // public BranchServiceImpl(BranchRepository branchRepository){
    //     this.branchRepository = branchRepository;
    // }

    @Override
    public Branch addBranch(Branch branch) {
        Branch branchEntity = new Branch();
        BeanUtils.copyProperties(branch, branchEntity);
        branchRepository.save(branchEntity);
        return branch;
    }

    @Override
    public List<Branch> getAllBranches() {
        List<Branch> branchEntities = branchRepository.findAll();
               return branchEntities;
    }

    @Override
    public Branch getBranchById(Long id) {
        Branch branchEntity = branchRepository.findById(id).get();
        return branchEntity;
    }

    @Override
    public boolean deleteBranch(Long id) {
        Branch branchEntity = branchRepository.findById(id).get();
        branchRepository.delete(branchEntity);
        return true;
    }

    @Override
    public Branch updateBranch(Long id, Branch branch) {
        Branch branchEntity = branchRepository.findById(id).get();
        branchEntity.setName(branch.getName());
        branchRepository.save(branchEntity);
        return branchEntity; 
    }

    @Override
    public Branch createNewBooking(Long branchId, Long userId) {
        Branch branchEntity = branchRepository.findById(branchId).get();
        // UserEntity userEntity = userRepository.findById(userId).get(); 
        // User user = new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
        // branchEntity.getBranchBookings(user);
        // branchRepository.save(branchEntity);
        return branchEntity;
    }

    
}
