package designPatterns.dependencyInjectionExample;

public class CustomerService {
    private final CustomerRepository customerRepository;

       public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer retrieveCustomerById(int id) {
        return customerRepository.fetchCustomerById(id);
    }
}
