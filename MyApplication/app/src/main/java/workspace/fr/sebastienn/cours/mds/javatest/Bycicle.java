package workspace.fr.sebastienn.cours.mds.javatest;

import workspace.fr.sebastienn.cours.mds.javatest.model.Vehicule;
import workspace.fr.sebastienn.cours.mds.javatest.model.Wheel;

//command + MAJ + A shortcut of all shortcut
//command + N getter and setter shortcut
public class Bycicle extends Vehicule {

    private String color;
    private Wheel frontWheel;
    private Wheel backWheel;

    public Bycicle() {
    }

    public Bycicle(Wheel frontWheel, Wheel backWheel) {
        this.color = color;
        this.frontWheel = frontWheel;
        this.backWheel = backWheel;
    }

    public Bycicle(String color, Wheel frontWheel, Wheel backWheel) {
        this.color = color;
        this.frontWheel = frontWheel;
        this.backWheel = backWheel;
    }

    public Wheel getBackWheel() {
        return backWheel;
    }

    public void setBackWheel(Wheel backWheel) {
        this.backWheel = backWheel;
    }

    public Wheel getFrontWheel() {
        return frontWheel;
    }

    public void setFrontWheel(Wheel frontWheel) {
        this.frontWheel = frontWheel;
    }

//    ccommand + n and add toString to show on debug
    @Override
    public String toString() {
        return "Bycicle{" +
                "color='" + color + '\'' +
                ", frontWheel=" + frontWheel +
                ", backWheel=" + backWheel +
                '}';
    }
}
