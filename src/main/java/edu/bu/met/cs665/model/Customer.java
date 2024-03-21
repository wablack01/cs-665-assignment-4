/**
 * Name: Walker Black
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: Customer.java
 * Description: This class is responsible for methods and attributes of a Customer.
 */

package edu.bu.met.cs665.model;

/**
 * This is Customer class.
 * It represents a customer whose data is stored by the application.
 */
public class Customer {
  private int customerId;
  private String name;

  /**
   * Create a new Customer.
   * @param customerId the customer's id
   * @param name the customer's name
   */
  public Customer(int customerId, String name) {
    this.customerId = customerId;
    this.name = name;
  }

  /**
   * Getter for the customer's id.
   * @return The customer's id
   */
  public int getCustomerId() {
    return customerId;
  }

  /**
   * Getter for the customer's name.
   * @return the customer's name
   */
  public String getName() {
    return name;
  }
}
