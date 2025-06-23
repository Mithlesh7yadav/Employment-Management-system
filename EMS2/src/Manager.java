import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private List<Employee> teamMembers;

    public Manager(String name, int age, double salary, String department) throws InvalidDataException, InvalidAgeException {
        super(name, age, salary, department);
        this.teamMembers = new ArrayList<>();
    }

    public void addTeamMember(Employee e) {
        teamMembers.add(e);
        e.setManager(this);
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    @Override
    public String toString() {
        return "Manager - " + super.toString();
    }
}