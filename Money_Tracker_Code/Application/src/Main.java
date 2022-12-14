import Facade.Facade;
import Visual.GUI;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    void run(){
        Facade facade = new Facade();
        GUI gui = new GUI(facade);
    }
}




















// Test Application without GUI

//public class Main {
//    public static void main(String[] args) throws Exception {
//        Facade facade = new Facade();
//
//        facade.addFriend("Stijn");
//        facade.addFriend("Joppe");
//
//        facade.createTicket("ticket1", "Joppe", false);
//        facade.addExpense("kinepolis parking", 20F, "Joppe", "parking", 5F);
//        facade.addExpense("kinepolis parking2", 15F, "Stijn", "parking", 0F);
//        facade.addExpense("kinepolis entrance", 10F, "Stijn", "entrance", 10);
//        facade.addExpense("kinepolis toilet", 3F, "Stijn", "toilet", 0F);
//        facade.addExpense("kinepolis popcorn", 5F, "Joppe", "snack", 0F);
//        facade.rememberTicket();
//
//        facade.loadTicket("ticket1", "Stijn", false);
//        facade.addTicket();
//
//        System.out.println(facade.getGlobalBill("Stijn"));
//        System.out.println(facade.calculateGlobalBill("Stijn"));
//        System.out.println(facade.getGlobalBill("Joppe"));
//        System.out.println(facade.calculateGlobalBill("Joppe"));
//    }
//}