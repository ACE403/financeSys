package com.example.validatingforminput.userAuthentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository interface for CRUD operations on financial data
@Repository
public interface FinancialDataRepository extends JpaRepository<FinancialData, Long> {
    @Query(value = "SELECT * FROM financial_data f WHERE f.user_email = :email", nativeQuery = true)
    List<FinancialData> findByUserEmail(@Param("email") String email);
}
