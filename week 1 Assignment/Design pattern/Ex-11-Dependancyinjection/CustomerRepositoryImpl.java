package designPatterns.dependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer fetchCustomerById(int id) {
        return new Customer(id, "Jane Doe");
    }
}
