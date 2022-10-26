package a21.climoilou.mono2.formatifs.formatif6.service.uiAnimation;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.Objects;

public class WindowAnimationService  {

    private LocationTaille souhaitee;
    private LocationTaille actuelle;
    private double tailleIncrement = 5;
    private double locationIncrement = 5;




    public static class  LocationTaille {
        private double x;
        private double y;
        private double largeur;
        private double longueur;

        public LocationTaille(double x, double y, double largeur, double longueur) {
            this.x = x;
            this.y = y;
            this.largeur = largeur;
            this.longueur = longueur;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getLargeur() {
            return largeur;
        }

        public void setLargeur(double largeur) {
            this.largeur = largeur;
        }

        public double getLongueur() {
            return longueur;
        }

        public void setLongueur(double longueur) {
            this.longueur = longueur;
        }

        @Override
        public LocationTaille clone() throws CloneNotSupportedException {
            return (LocationTaille) super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LocationTaille that)) return false;
            return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && Double.compare(that.largeur, largeur) == 0 && Double.compare(that.longueur, longueur) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, largeur, longueur);
        }
    }
}
