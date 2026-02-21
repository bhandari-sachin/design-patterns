package printer;

public abstract class PrinterDecorator implements Printer {
    protected final Printer wrappee;

    protected PrinterDecorator(Printer wrappee) {
        this.wrappee = wrappee;
    }
}
