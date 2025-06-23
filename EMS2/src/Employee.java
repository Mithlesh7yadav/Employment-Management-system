public class Employee extends Person {
    private double salary;
    private String department;
    private Manager manager;

    public Employee(String name, int age, double salary, String department) throws InvalidDataException, InvalidAgeException {
        super(name, age);
        if (age < 18) throw new InvalidAgeException("Age must be at least 18.");
        if (department == null || department.trim().isEmpty()) {
            throw new InvalidDataException("Department cannot be null or empty.");
        }
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Manager getManager() { return manager; }
    public void setManager(Manager manager) { this.manager = manager; }

    @Override
    public String toString() {
        String managerName = (manager != null) ? manager.getName() : "No Manager Assigned";
        return super.toString() + ", Salary: " + salary + ", Department: " + department + ", Manager: " + managerName;
    }
}