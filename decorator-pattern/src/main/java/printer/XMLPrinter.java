package printer;

public class XMLPrinter extends PrinterDecorator {
    public XMLPrinter(Printer wrappee) {
        super(wrappee);
    }
    @Override
    public void print(String message) {
        String xml = "<message>" + escapeXml(message) + "</message>";
        wrappee.print(xml);
    }

    private String escapeXml(String s) {
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");

    }
}
