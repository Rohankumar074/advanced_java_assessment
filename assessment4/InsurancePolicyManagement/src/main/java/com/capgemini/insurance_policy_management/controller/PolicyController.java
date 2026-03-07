package com.capgemini.insurance_policy_management.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.insurance_policy_management.dto.PolicyRequestDTO;
import com.capgemini.insurance_policy_management.dto.PolicyResponseDTO;
import com.capgemini.insurance_policy_management.service.PolicyService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
	
	private final PolicyService policyService;
    
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping 
    public ResponseEntity<PolicyResponseDTO> createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.createPolicy(dto));
    }

    @GetMapping
    public ResponseEntity<Page<PolicyResponseDTO>> getAllPolicies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "premiumAmount") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(policyService.getAllPolicies(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> updatePolicy(@PathVariable Long id, @Valid @RequestBody PolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.updatePolicy(id, dto));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByType(@PathVariable String type) {
        return ResponseEntity.ok(policyService.getPoliciesByType(type));
    }

    @GetMapping("/premium")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByPremium(
            @RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(policyService.getPoliciesByPremiumRange(min, max));
    }
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> cancelPolicy(@PathVariable Long id) {
        policyService.cancelPolicy(id);
        return ResponseEntity.noContent().build();
    }

	

}
