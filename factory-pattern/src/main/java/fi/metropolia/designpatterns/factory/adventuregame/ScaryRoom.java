package fi.metropolia.designpatterns.factory.adventuregame;

public class ScaryRoom implements Room {

    public void enter() {
        System.out.println("You entered a scary room. There is blood everywhere.");
    }
}