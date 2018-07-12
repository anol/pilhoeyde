public class Application {

    public static void main(String[] args) throws Exception {
        Pilhoyde pilhoyde = new Pilhoyde();
        // Fast korde
        pilhoyde.setVinkel(null);
        pilhoyde.setKorde(1000.0);
        pilhoyde.setRadius(10098.4);
        pilhoyde.print();
        pilhoyde.setRadius(9958.7);
        pilhoyde.print();
        pilhoyde.setRadius(9901.7);
        pilhoyde.print();
        System.out.println("");
        // Fast vinkel
        pilhoyde.setKorde(null);
        pilhoyde.setVinkel(22.5);
        pilhoyde.setRadius(10098.4);
        pilhoyde.print();
        pilhoyde.setRadius(10000.0);
        pilhoyde.print();
        pilhoyde.setRadius(9958.7);
        pilhoyde.print();
        pilhoyde.setRadius(9901.7);
        pilhoyde.print();
        System.out.println("");
    }

}
