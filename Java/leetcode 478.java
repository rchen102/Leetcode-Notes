class Solution {

    double xc;
    double yc;
    double rad;

    public Solution(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }
    
    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;
        while (true) {
            double x = x0 + Math.random() * rad * 2;
            double y = y0 + Math.random() * rad * 2;
            double distance = Math.sqrt(Math.pow(x - xc, 2) + Math.pow(y - yc, 2));
            if (distance < rad) {
                return new double[]{x, y};
            }
        }
    }
}