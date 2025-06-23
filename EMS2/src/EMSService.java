import java.util.*;
import java.util.stream.Collectors;

public class EMSService {
    private List<Employee> employees = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
        if (e instanceof Manager) {
            managers.add((Manager) e);
        }

        // Display names to help remember
        System.out.println("\n--- Current Employees ---");
        employees.stream().filter(emp -> !(emp instanceof Manager)).forEach(emp ->
                System.out.println("- " + emp.getName()));

        System.out.println("\n--- Current Managers ---");
        managers.forEach(manager -> System.out.println("- " + manager.getName()));
    }

    public void createProject(String projectName) {
        boolean exists = projects.stream()
                .anyMatch(p -> p.getProjectName().equalsIgnoreCase(projectName));
        if (exists) {
            System.out.println("Project already exists.");
        } else {
            projects.add(new Project(projectName));
            System.out.println("Project created: " + projectName);
        }
    }

    public void assignEmployeeToProjectWithDeadline(String empName, String projectName, int deadlineDays)
            throws EmployeeNotFoundException {
        Optional<Employee> emp = employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(empName)).findFirst();

        if (emp.isEmpty()) throw new EmployeeNotFoundException("Employee not found: " + empName);

        Project project = projects.stream()
                .filter(p -> p.getProjectName().equalsIgnoreCase(projectName)).findFirst()
                .orElseGet(() -> {
                    Project p = new Project(projectName);
                    projects.add(p);
                    return p;
                });

        project.assignEmployee(emp.get(), deadlineDays);
        System.out.println("Assigned " + empName + " to " + projectName + " with deadline: " + deadlineDays + " days.");
    }

    public void assignEmployeeToManager(String empName, String managerName) throws EmployeeNotFoundException {
        Employee employee = employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(empName) && !(e instanceof Manager)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found or is a Manager: " + empName));

        Manager manager = managers.stream()
                .filter(m -> m.getName().equalsIgnoreCase(managerName)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Manager not found: " + managerName));

        manager.addTeamMember(employee);
        employee.setManager(manager);

        System.out.println("Assigned employee '" + empName + "' to manager '" + managerName + "'.");
    }

    public void showEmployeesByManager(String managerName) throws EmployeeNotFoundException {
        Manager manager = managers.stream()
                .filter(m -> m.getName().equalsIgnoreCase(managerName)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Manager not found"));

        System.out.println("Team of " + managerName + ":");
        if (manager.getTeamMembers().isEmpty()) {
            System.out.println("  No employees assigned.");
        } else {
            manager.getTeamMembers().forEach(System.out::println);
        }
    }

    public void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n--- Employee Information ---");
        for (Employee emp : employees) {
            System.out.println(emp);
            if (emp.getManager() != null) {
                System.out.println("  Manager: " + emp.getManager().getName());
            }
            for (Project p : projects) {
                if (p.getAssignedEmployees().contains(emp)) {
                    System.out.println("  Assigned to Project: " + p.getProjectName() +
                            " | Deadline: " + p.getDeadlines().get(emp) + " days");
                }
            }
            System.out.println();
        }
    }

    public void showEmployeeHierarchy() {
        for (Manager manager : managers) {
            System.out.println("Manager: " + manager.getName());
            if (manager.getTeamMembers().isEmpty()) {
                System.out.println("  |- No team members assigned");
            } else {
                for (Employee emp : manager.getTeamMembers()) {
                    System.out.println("  |- " + emp.getName());
                }
            }
        }
    }

    public void filterHighSalaryEmployees(double threshold) {
        System.out.println("Employees with salary > " + threshold + ":");
        employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .forEach(System.out::println);
    }

    public void sortEmployeesByName() {
        System.out.println("Employees sorted by name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }

    public void sortEmployeesByAge() {
        System.out.println("Employees sorted by age:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);
    }

    public void groupEmployeesByDepartment() {
        System.out.println("Employees grouped by department:");
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        grouped.forEach((dept, emps) -> {
            System.out.println(dept + ":");
            emps.forEach(System.out::println);
        });
    }
}
