public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    final double G = 6.67 * Math.pow(10,-11);

    public Planet(double xp, double yp, double xV, double yV, double m, String img) {
        xxPos = xp;
        yyPos = yp;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xxDistance = this.xxPos - p.xxPos;
        double yyDistance = this.yyPos - p.yyPos;
        return Math.sqrt(Math.pow(xxDistance,2) + Math.pow(yyDistance,2));
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        return G * this.mass * p.mass / Math.pow(distance,2);
    }

    public double calcForceExertedByX(Planet p) {
        double x_distance = p.xxPos - this.xxPos;
        double distance = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * x_distance / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double y_distance = p.yyPos - this.yyPos;
        double distance = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * y_distance / distance;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceExertedByX = 0;
        for (Planet p: allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            netForceExertedByX += this.calcForceExertedByX(p);
        }
        return netForceExertedByX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceExertedByY = 0;
        for (Planet p: allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            netForceExertedByY += this.calcForceExertedByY(p);
        }
        return netForceExertedByY;
    }

    public void update(double t, double x_force, double y_force) {
        double a_x = x_force / this.mass;
        double a_y = y_force / this.mass;
        this.xxVel = a_x * t + this.xxVel;
        this.yyVel = a_y * t + this.yyVel;
        this.xxPos += t * xxVel;
        this.yyPos += t * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos,"images/" + imgFileName);
    }

}
