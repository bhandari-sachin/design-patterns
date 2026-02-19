package organization;

public interface OrgComponent {
    String getName();
    double getTotalSalary();

    // xml
    String toXml(int indentLevel);

    default String toXml() {
        return toXml(0);
    }
}