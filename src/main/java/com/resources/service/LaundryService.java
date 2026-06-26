package com.resources.service;

import com.resources.dao.CustomerDAO;
import com.resources.dao.OrderDAO;
import com.resources.model.Customer;
import com.resources.model.Order;
import java.util.List;

public class LaundryService {
    
    private CustomerDAO customerDAO = new CustomerDAO();
    private OrderDAO orderDAO = new OrderDAO();
    
    // ===== CUSTOMER =====
    public boolean registerCustomer(Customer customer) {
        if (customerDAO.getCustomerByContact(customer.getContactNumber()) != null) {
            System.out.println("❌ Customer already exists!");
            return false;
        }
        return customerDAO.saveCustomer(customer);
    }
    
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }
    
    public Customer getCustomerById(Long id) {
        return customerDAO.getCustomerById(id);
    }
    
    public Customer getCustomerByContact(String contact) {
        return customerDAO.getCustomerByContact(contact);
    }
    
    public List<Customer> searchCustomers(String keyword) {
        return customerDAO.searchCustomers(keyword);
    }
    
    public boolean updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }
    
    public boolean deleteCustomer(Long id) {
        return customerDAO.deleteCustomer(id);
    }
    
    // ===== ORDER =====
    public boolean createOrder(Order order) {
        Customer customer = customerDAO.getCustomerById(order.getCustomerId());
        if (customer == null) {
            System.out.println("❌ Customer not found!");
            return false;
        }
        
        int estimatedTime = 0;
        if (order.getServices().contains("Wash")) estimatedTime += 30;
        if (order.getServices().contains("Dry")) estimatedTime += 20;
        if (order.getServices().contains("Fold")) estimatedTime += 15;
        
        order.setProcessingTime(estimatedTime);
        order.setRemainingTime(estimatedTime);
        order.setStatus("pending");
        
        return orderDAO.saveOrder(order);
    }
    
    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id);
    }
    
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orderDAO.getOrdersByCustomer(customerId);
    }
    
    public List<Order> getOrdersByStatus(String status) {
        return orderDAO.getOrdersByStatus(status);
    }
    
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
    
    public boolean updateOrderStatus(Long id, String status) {
        return orderDAO.updateOrderStatus(id, status);
    }
    
    public boolean updateOrderDetails(Long id, Double weight, Double price) {
        return orderDAO.updateOrderDetails(id, weight, price);
    }
    
    public boolean deleteOrder(Long id) {
        return orderDAO.deleteOrder(id);
    }
}