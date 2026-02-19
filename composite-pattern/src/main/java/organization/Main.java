package organization;

public class Main {
    public static void main(String[] args) {
        // Root of organization (top-level department)
        Department org = new Department("Acme Corporation");

        // Departments
        Department engineering = new Department("Engineering");
        Department hr = new Department("HR");
        Department platform = new Department("Platform");
        Department mobile = new Department("Mobile");

        // Employees
        Employee alice = new Employee("Alice", 5000);
        Employee bob = new Employee("Bob", 4500);
        Employee carol = new Employee("Carol", 6000);
        Employee dave = new Employee("Dave", 4000);
        Employee eve = new Employee("Eve", 4200);

        // Build hierarchy (add anytime)
        org.add(engineering);
        org.add(hr);

        engineering.add(platform);
        engineering.add(mobile);

        platform.add(alice);
        platform.add(bob);

        mobile.add(carol);

        hr.add(dave);
        hr.add(eve);

        // Total salary in one call
        System.out.println("Total salary: " + org.getTotalSalary());

        // Remove in one call
        hr.remove(eve);
        System.out.println("Total salary after removing Eve: " + org.getTotalSalary());

        // Add in one call
        engineering.add(new Employee("Frank", 7000));
        System.out.println("Total salary after adding Frank: " + org.getTotalSalary());

        // Print XML in one call
        System.out.println("\n--- Organization XML ---");
        System.out.print(org.toXml());
    }
}

