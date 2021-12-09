
public class Ape extends Animal {
int climbingHeight;

    public Ape(String name, String favoriteActivity, String favoriteFood, int climbingHeight) {
        super(name, favoriteActivity, favoriteFood);
        this.climbingHeight = climbingHeight;
    }


    public Ape(String name, String favoriteActivity, String favoriteFood) {
        super(name,favoriteActivity, favoriteFood);
    }



    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " " + climbingHeight;
    }





}
