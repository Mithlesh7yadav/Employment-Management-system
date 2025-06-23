import java.util.*;

public class Project {
    private String projectName;
    private Map<Employee, Integer> deadlines = new HashMap<>();

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public void assignEmployee(Employee e, int days) {
        deadlines.put(e, days);
    }

    public List<Employee> getAssignedEmployees() {
        return new ArrayList<>(deadlines.keySet());
    }

    public String getProjectName() {
        return projectName;
    }

    public Map<Employee, Integer> getDeadlines() {
        return deadlines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Project: " + projectName + "\n");
        deadlines.forEach((emp, days) -> sb.append(emp.getName()).append(" - Deadline: ").append(days).append(" days\n"));
        return sb.toString();
    }
}
