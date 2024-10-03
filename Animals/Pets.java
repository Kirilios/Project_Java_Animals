package Animals;

public class Pets extends Animals {

    private String[] actions;

    public Pets(String name, String birthday, String type, String[] actions) {
        super(name, birthday, type);
        this.actions = actions;
    }

    public String[] getActions() {
        return actions;
    }
    public void setActions(String[] actions){
        this.actions = actions;
    }

    @Override
    public void showInfo() {
        super.showInfo();
    }

    public void showActions(){
        System.out.println("Actions: ");
        for(String action: actions){
            System.out.println(action);
        }
    }
}
