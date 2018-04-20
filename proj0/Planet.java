public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double g = 6.67E-11;

	public Planet(double xP, double yP, double xV,
				 double yV, double m, String img){
		xxPos = xP; yyPos = yP; xxVel = xV;
		yyVel = yV; mass = m; imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this. xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
	} 

	public double calcForceExertedBy(Planet p){
		return g * p.mass * this.mass / Math.pow(this.calcDistance(p), 2);
	}

	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] ps){
		double netForce = 0;
		for(Planet p : ps){
			if(!this.equals(p)){
				netForce += this.calcForceExertedByX(p);
			}
		}
		return netForce;
	}

	public double calcNetForceExertedByY(Planet[] ps){
		double netForce = 0;
		for(Planet p : ps){
			if(!this.equals(p)){
				netForce += this.calcForceExertedByY(p);
			}
		}
		return netForce;
	}

	public void update(double dt, double xForce, double yForce){
		double xAcceleration = xForce / this.mass;
		double yAcceleration = yForce / this.mass;
		this.xxVel +=  xAcceleration * dt;
		this.yyVel +=  yAcceleration * dt;
		this.xxPos += this.xxVel * dt;
		this.yyPos += this.yyVel * dt;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}

}