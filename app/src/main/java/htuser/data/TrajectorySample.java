package htuser.data;

import org.team2363.helixtrajectory.HolonomicTrajectorySample;

public class TrajectorySample {
  public double timestamp;
  public double x;
  public double y;
  public double heading;
  public double velocityX;
  public double velocityY;
  public double angularVelocity;

  public TrajectorySample(HolonomicTrajectorySample sample, double timestamp) {
    this.timestamp = timestamp;
    this.x = sample.x;
    this.y = sample.y;
    this.heading = sample.heading;
    this.velocityX = sample.velocityX;
    this.velocityY = sample.velocityY;
    this.angularVelocity = sample.angularVelocity;
  }
}
