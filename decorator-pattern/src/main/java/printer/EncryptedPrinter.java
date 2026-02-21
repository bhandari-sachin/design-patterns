package printer;

public class EncryptedPrinter extends PrinterDecorator {

    private final int shift;

    public EncryptedPrinter(Printer wrappee) {
        this(wrappee, 3); // default shift
    }

    public EncryptedPrinter(Printer wrappee, int shift) {
        super(wrappee);
        this.shift = ((shift % 26) + 26) % 26;
    }

    @Override
    public void print(String message) {
        String encrypted = caesar(message, shift);
        wrappee.print(encrypted);
    }

    // helper to prove decrypt-ability
    public String decrypt(String encryptedText) {
        int back = (26 - shift) % 26;
        return caesar(encryptedText, back);
    }

    private String caesar(String text, int shift) {
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + shift) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + shift) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}