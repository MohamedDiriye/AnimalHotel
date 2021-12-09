import java.util.ArrayList;
import java.util.Scanner;

public class ZooHotelBookingSystem {
    static ArrayList<Room> rooms = new ArrayList<>();

    static String slogan;

    public ZooHotelBookingSystem(String slogan) {
        this.slogan = slogan;
    }

    public static void start() {

        /*
        Hårdkodade rum, användaren kan ej ta
        bort/lägga till rum när programmet körs.
         */
        TheCave room02 = new TheCave("102", 45);
        rooms.add(room02);

        JungleBreeze room03 = new JungleBreeze("103", 50);
        rooms.add(room03);

        UrbanStay room04 = new UrbanStay("104", 60);
        rooms.add(room04);


        boolean runProgram = true;
        while (runProgram) {
            printMenu();
            int dataInput = getUserInt();
            switch (dataInput) {
                case 1 -> printAllRooms();
                case 2 -> reserveRooms();
                case 3 -> showBookings();
                case 4 -> changeBooking();
                case 5 -> deleteBooking();
                case 6 -> searchBookings();
                case 7 -> searchGuests();
                case 8 -> {
                    runProgram = false;
                    System.out.println(" Thank you and welcome back");
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("============================");
        System.out.println("    Welcome To ZooHotel");
        System.out.println("============================ \n");
        System.out.println(" 1. List of all rooms");
        System.out.println(" 2. Reserve/Check-in room");
        System.out.println(" 3. Show the bookings");
        System.out.println(" 4. Change bookings");
        System.out.println(" 5. Delete bookings");
        System.out.println(" 6. Search for bookings");
        System.out.println(" 7. Filter search");
        System.out.println(" 8. Quit program");
        System.out.println("=============================");
        System.out.print("> ");

    }


    public static String getUserString() {
        Scanner myScan = new Scanner(System.in);
        String userInput = myScan.nextLine();

        return userInput;
    }

    public static int getUserInt() {
        Scanner myScan = new Scanner(System.in);
        int userInput;

        while (true) {
            try {
                userInput = Integer.parseInt(myScan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sorry, wrong input. Try again");
            }

        }
        return userInput;
    }

    //Här får vi upp alla rum m.h.a foreach-loop.

    public static void printAllRooms() {

        System.out.println(slogan);

        int counter = 1;
        for (Room room : rooms) {
            System.out.println(counter + ". " + room.roomName + ": " + room.getStatus() + " - " + room.getDescription() + " and it costs " + room.getPrice() + " $ /night");
            counter++;
        }
    }

    //Visar upp bokningar som har gjorts m.h.a for-loop.
    public static void showBookings() {

        int counter = 1;
        for (Room room : rooms) {
            if (!room.isEmpty()) {
                System.out.println(" " + room.roomName + " RoomNbr " + counter + ":  " + room.getStatus() + " by " + room.getGuest().getName() +
                        room.getGuest().getFavoriteFood() + room.getGuest().getFavoriteActivity());
            }
            counter++;
        }
    }


    public static void reserveRooms() {
        System.out.println("Rooms available \n");
        printAllRooms();
        System.out.println("Choose the room");
        System.out.print("> ");


        System.out.println("Please type in all info about the guest down below \n");
        System.out.println(" What type of animal are you?");
        String animalType = getUserString();
        System.out.println("Guest's name");

        System.out.print("> ");
        String guestName = getUserString();

        System.out.println("Favorite activity");
        System.out.print("> ");
        String favoriteActivity = getUserString();

        System.out.println("Favorite food");
        System.out.print("> ");
        String favoriteFood = getUserString();

        printAllRooms();
        System.out.println(" Which room would you like to book?");
        System.out.print("> ");
        int r = Integer.parseInt(getUserString());

        switch (animalType) {
            case "Ape" -> {
                System.out.println("How high can you climb?");
                int attri = getUserInt();

                Ape myApe = new Ape(guestName, favoriteActivity, favoriteFood, attri);
                rooms.get(r - 1).book(myApe);
            }
            case "Shark" -> {
                System.out.println("How far can you swim?");
                int attri = getUserInt();

                Shark myShark = new Shark(guestName, favoriteActivity, favoriteFood, attri);
                rooms.get(r - 1).book(myShark);

            }
            case "Bird" -> {
                System.out.println("How high can you fly?");
                int attri = getUserInt();

                Bird myBird = new Bird(guestName, favoriteActivity, favoriteFood, attri);
                rooms.get(r - 1).book(myBird);
            }
            case "Dog" -> {
                System.out.println("How far can you smell?");
                int attri = getUserInt();

                Dog myDog = new Dog(guestName, favoriteActivity, favoriteFood, attri);
                rooms.get(r - 1).book(myDog);

            }
            default -> {
                Animal x = new Animal(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(x);
            }
        }
    }

    public static void changeBooking() {

        System.out.println(" Which room do you belong to?");
        int n1 = getUserInt();

        System.out.println(" What would you like to change?");

        System.out.println(" 1. Favourite Activity?");
        System.out.println(" 2. Favourite Food?");
        int n2 = getUserInt();
        System.out.println(" What would you like to change to?");
        String s = getUserString();
// Här tar vi svaret från användaren som är av typen int och sätter -1, för att få fram rätt index från vår arrayList.
        if (n2 == 1 && !rooms.get(n1 - 1).isEmpty) {
            rooms.get(n1 - 1).getGuest().setFavoriteActivity(s);
        } else if (n2 == 2 && !rooms.get(n1 - 1).isEmpty) {
            rooms.get(n1 - 1).getGuest().setFavoriteFood(s);

        } else {
            System.out.println("Invalid input");
        }
    }

    public static void searchBookings() {
        System.out.println("Search either guest or room");
        System.out.print("> ");
        String s1 = getUserString();

        // använder en forloop med två ifsatster.Första f-satsen för att loopa igenom rummen med gäster och
// den andra ifsatsen körs för att filtrera gästerna med bokstäverna som användaren angett.

        if (s1.equals("guest")) {
            System.out.println(" What's the name of the guest?");
            String s2 = getUserString();
            String answer = " There is no guest by that name";
            for (int i = 0; i < rooms.size(); i++) {
                if (!rooms.get(i).isEmpty()) {

                    if (rooms.get(i).getGuest().getName().equals(s2)) {
                        answer = (rooms.get(i).getGuest().getInfo() + rooms.get(i));
                        i = rooms.size();
                    }
                }
            }
            System.out.println(answer);

        } else if (s1.equals("room")) {
            System.out.println("  Which room number?");
            int n = getUserInt() - 1;
            if (!rooms.get(n).isEmpty()) {
                System.out.println(rooms.get(n).getGuest().getInfo());

            } else {
                System.out.println(" There is no guest in this room");
            }

        } else {
            System.out.println(" Invalid input");
        }
    }


    public static void searchGuests() {
        System.out.println(" Type first letter of the guests name ");
        System.out.print("> ");
        String letter = getUserString();

        for (Room room : rooms) {
            //m.h.a. Metoden contains kan vi filtrera sökningen efter gästernas namn i bokningen.
            if (room.getGuest().getName().contains(letter)) {
                System.out.println("Name guest: " + room.getGuest().getName());

            } else {
                System.out.println("There is no guest with the letter: " + letter);
                //TODO: använd Try and Catch för att få bukt med röda textfelet
            }
        }
    }



        public static void deleteBooking() {
            System.out.println(" Which room do you belong to??");
            int n = getUserInt();

            if (!rooms.get(n - 1).isEmpty()) {
                rooms.get(n - 1).removeBooking();
                System.out.println("Booking is now deleted");

            } else {
                System.out.println(" This room is not booked");
            }
        }

        public static void quitProgram () {
            boolean runProgram = false;
        }

}



