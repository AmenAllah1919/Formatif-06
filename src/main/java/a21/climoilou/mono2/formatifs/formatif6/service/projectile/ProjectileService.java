package a21.climoilou.mono2.formatifs.formatif6.service.projectile;

import a21.climoilou.mono2.formatifs.formatif6.service.SlowHelper;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.util.Objects;

public class ProjectileService {

    private Etat etatInitial;
    private final double cadreLargeur = 1000;
    private final double cadreHauteur = 800;


    public static class Etat implements Cloneable {
        private double x = 0;
        private double y = 0;
        private double vx = 0;
        private double vy = 0;
        private double ax = 0;
        private double ay = 0;

        private double masse = 1.0;
        private double fx = 0;
        private double fy = -9.8;

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
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
