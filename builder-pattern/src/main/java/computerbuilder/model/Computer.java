package computerbuilder.model;

public class Computer {
    private String processor;
    private int ram; // in GB
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    // Setters
    public void setProcessor(String processor) { this.processor = processor; }
    public void setRam(int ram) { this.ram = ram; }
    public void setHardDrive(String hardDrive) { this.hardDrive = hardDrive; }
    public void setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                " - Processor: " + processor + "\n" +
                " - RAM: " + ram + " GB\n" +
                " - Storage: " + hardDrive + "\n" +
                " - Graphics: " + graphicsCard + "\n" +
                " - OS: " + operatingSystem + "\n";
    }
}
