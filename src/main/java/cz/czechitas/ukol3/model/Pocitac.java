package cz.czechitas.ukol3.model;

public class Pocitac {
    private boolean jeZapnuty;
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public String toString() {
        return "Tento pocitac je zapnuty: " + this.jeZapnuty + ". \nPocitac obsahuje disk, pamet a procesor." + " Disk ma kapacitu " + this.pevnyDisk.getKapacita() + " bytu " + " a ma vyuzite misto " + this.pevnyDisk.getVyuziteMisto() + " bytu. "
                + "\nPamet ma kapacitu " + this.ram.getKapacita() + " bytu."
                + "\nProcesor je od vyrobce " + this.cpu.getVyrobce() + " a ma rychlost " + this.cpu.getRychlost() + " Hz.";
    }

    public void zapniSe() {
        if (this.getRam() != null && this.getCpu() != null && this.getPevnyDisk() != null) {
            this.jeZapnuty = true;
            System.out.println("Pocitac se zapnul.");
        } else {
            System.err.println("Nemuzes zapnout pocitac, kdyz vsechny tri komponenty.");

        }
    }

    public void vypniSe() {
        this.jeZapnuty = false;
        System.out.println("Pocitac se vypnul.");
    }

    public boolean jeZapnuty() {
        return this.jeZapnuty;


    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (jeZapnuty) {
            long vysledneVyuziteMisto = this.pevnyDisk.getVyuziteMisto() + velikost;
            if (vysledneVyuziteMisto < this.pevnyDisk.getKapacita())
                this.pevnyDisk.setVyuziteMisto(vysledneVyuziteMisto);
            else
                System.err.println("Nemuzes ukladat takto velky soubor, protoze se nevejde.");
        } else {
            System.err.println("Pocitac neni zapnuty. Nema smysl vytvaret soubor.");
        }
    }

    public void vymazSouboryOVelikosti(long velikost) {
        if (jeZapnuty) {
            long vysledneVyuziteMisto = this.pevnyDisk.getVyuziteMisto() - velikost;
            if (vysledneVyuziteMisto > 0)
                this.pevnyDisk.setVyuziteMisto(vysledneVyuziteMisto);
            else
                System.err.println("Nemuzes smazat vic mista, nez tam je.");
        } else {
            System.err.println("Pocitac neni zapnuty. Nema smysl mazat soubor.");
        }
    }

}
