package cz.czechitas.ukol3.model;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        System.out.println("Program spuštěn.");

        Pocitac kamilinPocitac = new Pocitac();

        Procesor kamilinProcesor = new Procesor();
        kamilinProcesor.setRychlost(2_200_000_000_000L);
        kamilinProcesor.setVyrobce("AMD");
        System.out.println(kamilinProcesor.toString()); //demonstrace metody toString

        Pamet kamilinaPamet = new Pamet();
        kamilinaPamet.setKapacita(32_000_000_000L);
        System.out.println(kamilinaPamet.toString());

        Disk kamilinDisk = new Disk();
        kamilinDisk.setKapacita(1_000_000_000_000L);
        kamilinDisk.setVyuziteMisto(5_000_000_000L);
        System.out.println(kamilinDisk.toString());

        kamilinPocitac.setCpu(kamilinProcesor);
        kamilinPocitac.setRam(kamilinaPamet);
        kamilinPocitac.setPevnyDisk(kamilinDisk);

        System.out.println(kamilinPocitac.toString());

        if (kamilinPocitac.getRam() != null && kamilinPocitac.getCpu() != null && kamilinPocitac.getPevnyDisk() != null && kamilinPocitac.jeZapnuty() == false) {
            kamilinPocitac.zapniSe();
            System.out.println("Pocitace je zapnuty: " + kamilinPocitac.jeZapnuty());
        } else {
            System.err.println("Nemuzes zapnout pocitac, kdyz vsechny tri komponenty.");

        }

        System.out.println(kamilinPocitac.getPevnyDisk().getVyuziteMisto());
        kamilinPocitac.vytvorSouborOVelikosti(1000); //demonstrace nechybove metody
        System.out.println(kamilinPocitac.getPevnyDisk().getVyuziteMisto());
        kamilinPocitac.vymazSouboryOVelikosti(1000);
        System.out.println(kamilinPocitac.getPevnyDisk().getVyuziteMisto());
        kamilinPocitac.vymazSouboryOVelikosti(6000000000L); //demonstrace chybove metody
        kamilinPocitac.vytvorSouborOVelikosti(2_000_000_000_000L); //demonstrace chybove metody


        kamilinPocitac.vypniSe();
        System.out.println("Pocitace je zapnuty: " + kamilinPocitac.jeZapnuty());


    }


}
