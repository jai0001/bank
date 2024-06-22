package com.pace.demo.controller;

import com.pace.demo.model.Loan;
import com.pace.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanRepository.save(loan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
        Loan existingLoan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));

        existingLoan.setAmount(loanDetails.getAmount());
        existingLoan.setInterestRate(loanDetails.getInterestRate());
        existingLoan.setStartDate(loanDetails.getStartDate());
        existingLoan.setEndDate(loanDetails.getEndDate());
        existingLoan.setCustomer(loanDetails.getCustomer());

        Loan updatedLoan = loanRepository.save(existingLoan);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));

        loanRepository.delete(loan);
        return ResponseEntity.ok().build();
    }
}
