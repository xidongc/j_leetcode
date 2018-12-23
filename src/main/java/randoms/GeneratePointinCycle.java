package randoms;

import java.util.Random;

public class GeneratePointinCycle {
    private double radius;
    private double x_center;
    private double y_center;
    private Random rand;

    // rejection sampling
    public GeneratePointinCycle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {
        // x -> [x_center - this.radius, x_center + this.radius]
        // y -> [y_center - this.radius, y_center + this.radius]

        double newX = this.rand.nextDouble()*2*this.radius+x_center-this.radius;
        double newY = this.rand.nextDouble()*2*this.radius+y_center-this.radius;
        while ((Math.pow(newX-this.x_center, 2) + Math.pow(newY-this.y_center,2)) > radius*radius){
            newX = this.rand.nextDouble()*2*this.radius+x_center-this.radius;
            newY = this.rand.nextDouble()*2*this.radius+y_center-this.radius;
        }
        return new double[]{newX, newY};
    }

}
