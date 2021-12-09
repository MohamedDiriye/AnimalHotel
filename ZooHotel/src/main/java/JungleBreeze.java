public class JungleBreeze extends Room{

    /*
    public JungleBreeze(String roomNbr, int price, Animal guest) {
        super(roomNbr, price, guest);
        roomName = "JungleBreeze";
    }

     */

    public JungleBreeze(String roomNbr, int price) {
        super(roomNbr, price);
        roomName = "JungleBreeze";
    }

    public String getDescription() {
        String description = " Room with double bed and sofa. Also with balcony";
        return description;
    }
}
