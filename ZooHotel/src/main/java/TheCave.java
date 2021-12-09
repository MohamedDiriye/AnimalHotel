public class TheCave extends Room{
    public TheCave (String roomNbr, int price, Animal guest) {
        super(roomNbr, price, guest);
        roomName = "TheCave";
    }


    public TheCave(String roomNbr, int price) {
        super(roomNbr, price);
        roomName = "TheCave";
    }

    public String getDescription() {
        String description = " Room designed as a cave with a single bed made of rocks";
        return description;
    }
}
