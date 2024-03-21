/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: CustomerData_HTTPS.java
 * Description: This interface defines methods for HTTPS retrieval of customer data.
 */

package edu.bu.met.cs665.repository;

import edu.bu.met.cs665.model.Customer;

/**
 * CustomerData_HTTPS is an interface for accessing Customer data through HTTPS connections.
 */
public interface CustomerData_HTTPS {
  void printCustomer(int customerId);

  Customer getCustomer_HTTPS(int customerId);

  void addCustomer_HTTPS(Customer customer);
}
