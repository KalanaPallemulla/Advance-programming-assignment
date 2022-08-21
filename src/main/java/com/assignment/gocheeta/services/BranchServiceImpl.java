package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.Booking;
import com.assignment.gocheeta.entity.Branch;
import com.assignment.gocheeta.entity.User;
import com.assignment.gocheeta.repository.BookingRepository;
import com.assignment.gocheeta.repository.BranchRepository;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class BranchServiceImpl implements BranchService {
    private BranchRepository branchRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
        // this.userRepository = userRepository;
    }

    // public BranchServiceImpl(BranchRepository branchRepository){
    // this.branchRepository = branchRepository;
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
    public Branch createNewBooking(Long branchId, Long bookingId) {
        Branch branchEntity = branchRepository.findById(branchId).get();
        // User userEntity = userRepository.findById(userId).get();
        Booking booking = bookingRepository.findById(bookingId).get();
        branchEntity.branchBookings(booking);
        return branchRepository.save(branchEntity);

    }

}
