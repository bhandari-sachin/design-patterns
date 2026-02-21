package printer;

public class Main {
    public static void main(String[] args) {

        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        // demonstrate decrypt ability
        EncryptedPrinter enc = new EncryptedPrinter(new BasicPrinter(), 3);
        String sample = enc.decrypt("Khoor Zruog!");
        System.out.println("Decrypted sample: " + sample);
    }
}