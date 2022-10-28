package a21.climoilou.mono2.formatifs.formatif6.service.uiAnimation;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.TextField;

import java.util.Objects;

public class WindowAnimationService extends Service<WindowAnimationService.LocationTaille> {


    private double tailleIncrement = 5;
    private double locationIncrement = 5;
    private LocationTaille souhaitee = new LocationTaille(0, 0, 0, 0);
    private LocationTaille actuelle = new LocationTaille(0, 0, 0, 0);

    public void setSouhaitee(double x, double y, double largeur, double longueur) {
        this.souhaitee.setX(x);
        this.souhaitee.setY(y);
        this.souhaitee.setLargeur(largeur);
        this.souhaitee.setLongueur(longueur);
    }

    public void setActuelle(double x, double y, double largeur, double longueur) {
        this.actuelle.setX(x);
        this.actuelle.setY(y);
        this.actuelle.setLargeur(largeur);
        this.actuelle.setLongueur(longueur);
    }

    @Override
    protected Task<LocationTaille> createTask() {

        return new WindowAnimationTask();
    }

    private class WindowAnimationTask extends Task<LocationTaille> {

        @Override
        protected LocationTaille call() throws Exception {
            actuelle.setX(souhaitee.getX());
            actuelle.setY(souhaitee.getY());
            actuelle.setLargeur(souhaitee.getLargeur());
            actuelle.setLongueur(souhaitee.getLongueur());
            return null;
        }
    }

    public static class LocationTaille {
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
