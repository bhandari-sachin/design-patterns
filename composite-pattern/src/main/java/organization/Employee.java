package organization;

public class Employee implements OrgComponent {
    private final String name;
    private final double salary;


    public Employee(String name, double salary) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Employee name required");
        if (salary < 0) throw new IllegalArgumentException("Salary required");
        this.name = name;
        this.salary = salary;


    }
    @Override
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public String toXml(int indentLevel) {
        String indent = "  ".repeat(Math.max(0, indentLevel));
        return indent + "<employee name=\"" + escapeXml(name) + "\" salary=\"" + salary + "\"/>\n";
    }

    private static String escapeXml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}