package crossfarm.actions;

public class DuckSound implements MakeSound{
    public void makeSound() {
        System.out.println("gun ya");
    }

    public void doAction() { makeSound(); }
}
