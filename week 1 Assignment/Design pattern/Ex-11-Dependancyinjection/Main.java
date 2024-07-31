package designPatterns.dependencyInjectionExample;

public class Main {
    public static void main(String[] args) {
        
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
       
        CustomerService customerService = new CustomerService(customerRepository);
        
        
        Customer customer = customerService.retrieveCustomerById(1);
        
      
        System.out.println("Customer Details:");
        System.out.println("ID: " + customer.getId());
        System.out.println("Name: " + customer.getName());
    }
}

