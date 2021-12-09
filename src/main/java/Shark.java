
public class Shark extends Animal {
    int swimLength;

    public Shark(String name, String favoriteActivity, String favoriteFood, int swimLength) {
        super(name, favoriteActivity, favoriteFood);
        this.swimLength = swimLength;

    }


      public Shark(String name, String favoriteActivity, String favoriteFood) {
         super(name, favoriteActivity, favoriteFood);
      }



    public void swim() {
        System.out.println(" im swimming");
    }

    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " " + swimLength;
    }
}




