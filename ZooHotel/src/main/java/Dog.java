
public class Dog extends Animal {

    private int smellDistance;

    public Dog(String name, String favoriteActivity, String favoriteFood) {
        super(name, favoriteActivity, favoriteFood);
    }


    public Dog(String name, String favoriteActivity, String favoriteFood, int smellDistance) {
        super(name, favoriteActivity, favoriteFood);
        this.smellDistance = smellDistance;

    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " " + smellDistance;
    }
}


