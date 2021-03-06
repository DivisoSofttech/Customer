package com.diviso.graeshoppe.customer.service;

import com.diviso.graeshoppe.customer.domain.Customer;
import com.diviso.graeshoppe.customer.domain.OTPChallenge;
import com.diviso.graeshoppe.customer.domain.OTPResponse;
import com.diviso.graeshoppe.customer.service.dto.CustomerDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.diviso.graeshoppe.customer.domain.Customer}.
 */
public interface CustomerService {

    /**
     * Save a customer.
     *
     * @param customerDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDTO save(CustomerDTO customerDTO);
    
    CustomerDTO update(CustomerDTO customerDTO);

    /**
     * Get all the customers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDTO> findAll(Pageable pageable);


    /**
     * Get the "id" customer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDTO> findOne(Long id);

    /**
     * Delete the "id" customer.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the customer corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CustomerDTO> search(String query, Pageable pageable);
    
	OTPResponse sendSMS(Long  numbers);

	OTPChallenge verifyOTP(Long numbers, String code);

	Customer findByIdpCode(String reference);

	Optional<CustomerDTO> findByMobileNumber(Long mobileNumber);

	Boolean checkUserExists(String reference);
	
	Long findLoyaltyPointByIdpCode(String idpCode);
	
}
