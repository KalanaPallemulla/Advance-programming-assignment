package com.assignment.gocheeta.controller;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.gocheeta.entity.Branch;
import com.assignment.gocheeta.services.BranchService;


@RestController
@RequestMapping("/api/v1/")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService){
        this.branchService = branchService;
    }

    @PostMapping("/branch")
    public Branch addBranch(@RequestBody Branch branch){
        return branchService.addBranch(branch);
    }

    @GetMapping("/branches")
    public List<Branch> getAllBranches(){
        return branchService.getAllBranches();
    }

    @GetMapping("/branch/{id}")
    public Branch getBranchById(@PathVariable Long id){
        return branchService.getBranchById(id);
    }

    @DeleteMapping("/branch/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteBranch(@PathVariable Long id){
        boolean deleted = false;
        deleted = branchService.deleteBranch(id);
        Map<String,Boolean> response = new Hashtable<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/branch/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branch){
        branch = branchService.updateBranch(id, branch);
        return ResponseEntity.ok(branch);
    }

    @PutMapping("/branch/{branchId}/user/{userId}")
    Branch createNewBooking(@PathVariable Long branchId, @PathVariable Long userId){
        return branchService.createNewBooking(branchId, userId);
    }
}
