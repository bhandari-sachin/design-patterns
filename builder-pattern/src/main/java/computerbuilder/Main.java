package computerbuilder;

import computerbuilder.builder.ComputerBuilder;
import computerbuilder.builder.GamingComputerBuilder;
import computerbuilder.builder.OfficeComputerBuilder;
import computerbuilder.director.ComputerDirector;
import computerbuilder.model.Computer;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build a Gaming Computer
        System.out.println("--- Assembling Gaming Computer ---");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingPC = gamingBuilder.getComputer();
        System.out.println(gamingPC);

        // Build an Office Computer
        System.out.println("--- Assembling Office Computer ---");
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officePC = officeBuilder.getComputer();
        System.out.println(officePC);
    }
}
