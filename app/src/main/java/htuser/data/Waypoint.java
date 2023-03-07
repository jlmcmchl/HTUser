package htuser.data;

import java.util.List;
import org.team2363.helixtrajectory.HolonomicWaypoint;
import org.team2363.helixtrajectory.InitialGuessPoint;

public class Waypoint {
  public double angular_velocity;
  public boolean angular_velocity_constrained;
  public int control_interval_count;
  public double heading;
  public boolean heading_constrained;
  public String name;
  public boolean velocity_magnitude_constrained;
  public double velocity_x;
  public boolean velocity_x_constrained;
  public double velocity_y;
  public boolean velocity_y_constrained;
  public String waypoint_type;
  public double x;
  public boolean x_constrained;
  public double y;
  public boolean y_constrained;

  public HolonomicWaypoint toHolonomicWaypoint(
      List<InitialGuessPoint> guesses, List<org.team2363.helixtrajectory.Obstacle> obstacles) {
    return new HolonomicWaypoint(
        x,
        y,
        heading,
        velocity_x,
        velocity_y,
        angular_velocity,
        x_constrained,
        y_constrained,
        heading_constrained,
        velocity_x_constrained,
        velocity_y_constrained,
        velocity_magnitude_constrained,
        angular_velocity_constrained,
        control_interval_count,
        guesses,
        obstacles);
  }

  public InitialGuessPoint toInitialGuess() {
    return new InitialGuessPoint(x, y, heading);
  }
}
