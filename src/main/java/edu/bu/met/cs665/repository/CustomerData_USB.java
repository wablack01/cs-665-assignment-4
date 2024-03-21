/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: CustomerData_USB.java
 * Description: This interface defines methods for USB retrieval of customer data.
 */

package edu.bu.met.cs665.repository;

import edu.bu.met.cs665.model.Customer;

/**
 * CustomerData_USB is an interface for accessing Customer data through USB connections.
 */
public interface CustomerData_USB {
  void printCustomer(int customerId);

  Customer getCustomer_USB(int customerId);

  void addCustomer_USB(Customer customer);
}
