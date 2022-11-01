package a21.climoilou.mono2.formatifs.formatif6.service.projectile;

import a21.climoilou.mono2.formatifs.formatif6.service.SlowHelper;
import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.sql.Time;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ProjectileService extends ScheduledService {

    private Etat etatInitial = new Etat();
    private final double cadreLargeur = 1000;
    private final double cadreHauteur = 800;
    long tempsInitial = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

    @Override
    protected Task createTask() {
        return new ProjectileTask();
    }

    private class ProjectileTask extends Task<Etat> {

        @Override
        protected Etat call() throws Exception {

            Etat cloneEtatInitial = (Etat) etatInitial.clone();

            double deltaTemps = trouverDeltaT();
            tempsInitial = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            if (etatInitial.getX() != cadreLargeur && etatInitial.getY() != 0) {
                SlowHelper.slow(15);
                etatInitial.setVy(trouverVYFinal(cloneEtatInitial.getVy(), cloneEtatInitial.getAy(), deltaTemps));
                etatInitial.setY(trouverY(cloneEtatInitial.getY(), cloneEtatInitial.getVy(), deltaTemps));
                etatInitial.setX(trouverXFinal(cloneEtatInitial.getX(), cloneEtatInitial.getVx(), deltaTemps));
            } else {
                cancel();
            }
            return etatInitial;
        }

        private double trouverDeltaT() {
            return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - tempsInitial;
        }

        private static double trouverXFinal(double xInitial, double vx, double dt) {
            double xFinal = xInitial + (vx * dt);
            return xFinal;
        }

        private static double trouverVYFinal(double vyInitial, double ay, double dt) {
            double vyFinal = vyInitial + (ay * dt);
            return vyFinal;
        }


        private static double trouverY(double yInitial, double vy, double dt) {
            double yFinal = (vy * dt) + yInitial;
            return yFinal;
        }
    }

    public static class Etat implements Cloneable {
        private double x;
        private double y;
        private double vx;
        private double vy;
        private double ax;
        private double ay;
        private double masse;
        private double fx;
        private double fy;

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

        public double getVx() {
            return vx;
        }

        public void setVx(double vx) {
            this.vx = vx;
        }

        public double getVy() {
            return vy;
        }

        public void setVy(double vy) {
            this.vy = vy;
        }

        public double getAx() {
            return ax;
        }

        public void setAx(double ax) {
            this.ax = ax;
        }

        public double getAy() {
            return ay;
        }

        public void setAy(double ay) {
            this.ay = ay;
        }

        public double getMasse() {
            return masse;
        }

        public void setMasse(double masse) {
            this.masse = masse;
        }

        public double getFx() {
            return fx;
        }

        public void setFx(double fx) {
            this.fx = fx;
        }

        public double getFy() {
            return fy;
        }

        public void setFy(double fy) {
            this.fy = fy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Etat etat)) return false;
            return Double.compare(etat.x, x) == 0 && Double.compare(etat.y, y) == 0 && Double.compare(etat.vx, vx) == 0 && Double.compare(etat.vy, vy) == 0 && Double.compare(etat.ax, ax) == 0 && Double.compare(etat.ay, ay) == 0 && Double.compare(etat.masse, masse) == 0 && Double.compare(etat.fx, fx) == 0 && Double.compare(etat.fy, fy) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, vx, vy, ax, ay, masse, fx, fy);
        }

        @Override
        public String toString() {
            return "Etat{" +
                    "x=" + x +
                    ", y=" + y +
                    ", vx=" + vx +
                    ", vy=" + vy +
                    ", ax=" + ax +
                    ", ay=" + ay +
                    ", masse=" + masse +
                    ", fx=" + fx +
                    ", fy=" + fy +
                    '}';
        }


        public Etat() {
            this.x = 15;
            this.y = 15;
            this.vx = 15;
            this.vy = 50;
            this.ax = 0;
            this.ay = -9.8;
            this.masse = 1;
            this.fx = 0;
            this.fy = -9.8;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
