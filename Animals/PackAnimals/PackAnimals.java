package Animals.PackAnimals;

import Animals.Animals;

public class PackAnimals extends Animals {

    private String[] actions;

    public PackAnimals(String name, String birthday, String type, String[] actions) {
        super(name, birthday, type);
        this.actions = actions;
    }

    public String[] getActions() {
        return actions;
    }

    public void setActions(String[] actions) {
        this.actions = actions;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        showActions();
    }

    @Override
    public void showActions() {
        System.out.println("Actions: ");
        if (actions != null && actions.length > 0) {
            for (String action : actions) {
                System.out.println("- " + action);
            }
        } else {
            System.out.println("No actions available.");
        }
    }
}
