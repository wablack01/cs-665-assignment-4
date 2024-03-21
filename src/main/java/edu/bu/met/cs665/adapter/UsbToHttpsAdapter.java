/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: UsbToHttpsAdapter.java
 * Description: This class is responsible for the methods and attributes of a UsbToHttpsAdapter.
 */

package edu.bu.met.cs665.adapter;

import edu.bu.met.cs665.model.Customer;
import edu.bu.met.cs665.repository.CustomerData_HTTPS;
import edu.bu.met.cs665.repository.CustomerData_USB;
import edu.bu.met.cs665.repository.HttpsCustomerDataRepository;

/**
 * This is the UsbToHttpsAdapter class.
 * This class rewires calls to the CustomerData_USB interface
 * to functionality of the CustomerData_Https interface
 */
public class UsbToHttpsAdapter implements CustomerData_USB {
  private final CustomerData_HTTPS repository;

  /**
   * Create new UsbToHttpsAdapter with a given CustomerData_HTTPS implementation.
   * @param customerDataRepository the CustomerData_HTTPS implementation
   */
  public UsbToHttpsAdapter(CustomerData_HTTPS customerDataRepository) {
    this.repository = customerDataRepository;
  }

  /**
   * Print customer data based on the customerId.
   * @param customerId The customer id for the customer whose data will print.
   */
  @Override
  public void printCustomer(int customerId) {
    repository.printCustomer(customerId);
  }

  /**
   * Get customer data based on the customerId.
   * @param customerId The customer id for the customer whose data will be returned.
   */
  @Override
  public Customer getCustomer_USB(int customerId) {
    return repository.getCustomer_HTTPS(customerId);
  }

  /**
   * Adds a customer to the customer repository.
   * @param customer The customer to add to the repository
   */
  @Override
  public void addCustomer_USB(Customer customer) {
    repository.addCustomer_HTTPS(customer);
  }
}
