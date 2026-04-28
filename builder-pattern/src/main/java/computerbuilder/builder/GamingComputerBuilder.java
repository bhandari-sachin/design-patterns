package computerbuilder.builder;

import computerbuilder.model.Computer;

public class GamingComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() { computer.setProcessor("Intel Core i9-14900K"); }

    @Override
    public void buildRAM() { computer.setRam(32); }

    @Override
    public void buildHardDrive() { computer.setHardDrive("2TB NVMe SSD"); }

    @Override
    public void buildGraphicsCard() { computer.setGraphicsCard("NVIDIA GeForce RTX 4090"); }

    @Override
    public void buildOperatingSystem() { computer.setOperatingSystem("Windows 11 Home"); }

    @Override
    public Computer getComputer() { return this.computer; }
}