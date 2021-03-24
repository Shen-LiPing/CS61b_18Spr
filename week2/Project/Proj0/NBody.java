public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass  = in.readDouble();
            String imgFileName = in.readString();
            Planet a = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
            planets[i] = a;
        }
        return planets;
    }

    public static void main(String[] args) {
       String[] argv = new String[3];
       argv[0] = "157788000.0";
       argv[1] = "25000.0";
       argv[2] = "data/planets.txt";
        double T = Double.parseDouble(argv[0]);
        double dt = Double.parseDouble(argv[1]);
        String filename = argv[2];
        /* double T = Double.parseDouble(args[0]);
         double dt = Double.parseDouble(args[1]);
         String filename = args[2];*/
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
//        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius,radius);
        StdDraw.picture(0,0,"images/starfield.jpg");

        for (double i = 0; i <= T; i += dt) {
            for (Planet p: planets) {
                p.update(dt,p.calcNetForceExertedByX(planets),p.calcNetForceExertedByY(planets));
                p.draw();
                StdDraw.show();
                StdDraw.enableDoubleBuffering();
                StdDraw.pause(1);
            }
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
  }

