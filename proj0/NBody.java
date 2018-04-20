/**Class that runs the simulation.
*/
public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int num = in.readInt();
		in.readDouble();
		Planet[] planets = new Planet[num];
		for(int i = 0; i<num; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();			
			planets[i] = new Planet(xP, yP, xV, yV, m, img);
		}
		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		String background = "images/starfield.jpg";
		double universeRadius = readRadius(filename);
		StdDraw.setScale(-universeRadius, universeRadius);
		StdDraw.clear();
		StdDraw.picture(0, 0, background, 2*universeRadius, 2*universeRadius);
		for(Planet p : planets){
			p.draw();
		}
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time <= T){
			StdDraw.clear();
			double[] xForce = new double[planets.length];
			double[] yForce = new double[planets.length];
			for (int i = 0; i<planets.length; i++){
				xForce[i] = planets[i].calcNetForceExertedByX(planets);
				yForce[i] = planets[i].calcNetForceExertedByY(planets);				
			}
			for (int i = 0; i<planets.length; i++){
				planets[i].update(dt, xForce[i], yForce[i]);
			}
			StdDraw.picture(0, 0, background, 2*universeRadius, 2*universeRadius);
			for(Planet p : planets){
			p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", universeRadius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
    }
}