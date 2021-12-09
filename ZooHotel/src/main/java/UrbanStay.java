public class UrbanStay extends Room{

   /* //1:a konstruktor kopplas till rummen.
    public UrbanStay(String roomNbr, int price, Animal guest) {
        super(roomNbr, price, guest);
        roomName = "UrbanStay";
    }

    */

    public UrbanStay(String roomNbr, int price) {
        super(roomNbr, price);
        roomName = "UrbanStay";
    }

    public String getDescription() {
        return  " Room with double bed and amazing view of the city";

    }
}
