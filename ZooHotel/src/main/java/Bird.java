
public class Bird extends Animal {
private int flyDistance;
   public Bird(String name, String favoriteActivity, String favoriteFood) {
        super(name, favoriteActivity, favoriteFood);
    }


    public Bird(String name, String favoriteActivity, String favoriteFood, int flyDistance) {
        super(name, favoriteActivity, favoriteFood);
        this.flyDistance = flyDistance;
    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " " + flyDistance;
    }
}