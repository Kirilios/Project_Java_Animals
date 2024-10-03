package Animals;

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
    }

    @Override
    public void showActions() {
        System.out.println("Actions: ");
        for(String action: actions){
            System.out.println(action);
        }
    }
}
