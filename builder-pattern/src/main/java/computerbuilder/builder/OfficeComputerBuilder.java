package computerbuilder.builder;

import computerbuilder.model.Computer;

public class OfficeComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() { computer.setProcessor("Intel Core i5-13400"); }

    @Override
    public void buildRAM() { computer.setRam(16); }

    @Override
    public void buildHardDrive() { computer.setHardDrive("512GB SSD"); }

    @Override
    public void buildGraphicsCard() { computer.setGraphicsCard("Intel UHD Graphics 730"); }

    @Override
    public void buildOperatingSystem() { computer.setOperatingSystem("Windows 11 Pro"); }

    @Override
    public Computer getComputer() { return this.computer; }
}
