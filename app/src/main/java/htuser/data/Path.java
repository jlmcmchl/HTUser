package htuser.data;

import java.util.ArrayList;
import java.util.List;
import org.team2363.helixtrajectory.HolonomicPath;
import org.team2363.helixtrajectory.HolonomicWaypoint;
import org.team2363.helixtrajectory.InitialGuessPoint;

public class Path {
  public List<Obstacle> obstacles;
  public List<Waypoint> waypoints;

  public HolonomicPath toHolonomicPath() throws Exception {
    ArrayList<org.team2363.helixtrajectory.Obstacle> exported_obstacles = new ArrayList<>();

    for (var obs : obstacles) {
      exported_obstacles.add(obs.toHTObstacle());
    }

    ArrayList<HolonomicWaypoint> exported_waypoints = new ArrayList<>();
    ArrayList<InitialGuessPoint> guesses = new ArrayList<>();
    for (Waypoint wp : waypoints) {
      switch (wp.waypoint_type) {
        case "initial_guess":
          guesses.add(wp.toInitialGuess());
          break;
        case "custom":
          exported_waypoints.add(wp.toHolonomicWaypoint(guesses, exported_obstacles));

          guesses = new ArrayList<>();
          exported_obstacles = new ArrayList<>();
          break;
        default:
          throw new Exception(String.format("WP type Not Implemented: %s", wp.waypoint_type));
      }
    }

    return new HolonomicPath(exported_waypoints);
  }
}
