import java.util.Scanner;

public class EMSApp {
    public static void main(String[] args) {
        EMSService service = new EMSService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- EMS Console ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Manager");
            System.out.println("3. Create Project");
            System.out.println("4. Assign Employee to Project (with deadline)");
            System.out.println("5. Assign Employee to Manager");
            System.out.println("6. Show Employees under a Manager");
            System.out.println("7. Filter High Salary Employees");
            System.out.println("8. Sort Employees by Name");
            System.out.println("9. Sort Employees by Age");
            System.out.println("10. Group Employees by Department");
            System.out.println("11. Show All Employees");
            System.out.println("12. Show Employee Hierarchy");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Age: ");
                        int age = scanner.nextInt();
                        System.out.print("Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Department: ");
                        String dept = scanner.nextLine();
                        service.addEmployee(new Employee(name, age, salary, dept));
                    }
                    case 2 -> {
                        System.out.print("Manager Name: ");
                        String mName = scanner.nextLine();
                        System.out.print("Age: ");
                        int mAge = scanner.nextInt();
                        System.out.print("Salary: ");
                        double mSalary = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Department: ");
                        String mDept = scanner.nextLine();
                        service.addEmployee(new Manager(mName, mAge, mSalary, mDept));
                    }
                    case 3 -> {
                        System.out.print("Enter Project Name: ");
                        String projectName = scanner.nextLine();
                        service.createProject(projectName);
                    }
                    case 4 -> {
                        System.out.print("Employee Name: ");
                        String empName = scanner.nextLine();
                        System.out.print("Project Name: ");
                        String projName = scanner.nextLine();
                        System.out.print("Deadline in days: ");
                        int days = scanner.nextInt();
                        service.assignEmployeeToProjectWithDeadline(empName, projName, days);
                    }
                    case 5 -> {
                        System.out.print("Employee Name: ");
                        String eName = scanner.nextLine();
                        System.out.print("Manager Name: ");
                        String manName = scanner.nextLine();
                        service.assignEmployeeToManager(eName, manName);
                    }
                    case 6 -> {
                        System.out.print("Manager Name: ");
                        String manager = scanner.nextLine();
                        service.showEmployeesByManager(manager);
                    }
                    case 7 -> {
                        System.out.print("Salary Threshold: ");
                        double threshold = scanner.nextDouble();
                        service.filterHighSalaryEmployees(threshold);
                    }
                    case 8 -> service.sortEmployeesByName();
                    case 9 -> service.sortEmployeesByAge();
                    case 10 -> service.groupEmployeesByDepartment();
                    case 11 -> service.showAllEmployees();
                    case 12 -> service.showEmployeeHierarchy();
                    case 13 -> {
                        running = false;
                        System.out.println("Exiting EMS...");
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}