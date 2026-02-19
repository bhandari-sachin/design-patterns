package organization;

import java.util.ArrayList;
import java.util.List;

public class Department implements OrgComponent {
    private final String name;
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Department name required");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // Single method call add
    public void add(OrgComponent component) {
        if (component == null) throw new IllegalArgumentException("Component cannot be null");
        children.add(component);
    }

    // Single method call remove
    public void remove(OrgComponent component) {
        children.remove(component);
    }

    @Override
    public double getTotalSalary() {
        double sum = 0.0;
        for (OrgComponent c : children) {
            sum += c.getTotalSalary();
        }
        return sum;
    }

    @Override
    public String toXml(int indentLevel) {
        String indent = "  ".repeat(Math.max(0, indentLevel));
        StringBuilder sb = new StringBuilder();

        sb.append(indent)
                .append("<department name=\"")
                .append(escapeXml(name))
                .append("\">\n");

        for (OrgComponent c : children) {
            sb.append(c.toXml(indentLevel + 1));
        }

        sb.append(indent).append("</department>\n");
        return sb.toString();
    }

    private static String escapeXml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}

