package htuser.data;

import java.util.List;
import org.team2363.helixtrajectory.ObstaclePoint;

public class Obstacle {
  public double center_x;
  public double center_y;
  public double length;
  public String name;
  public String obstacle_type;
  public double rotate_angle;
  public double safety_distance;
  public double width;

  public org.team2363.helixtrajectory.Obstacle toHTObstacle() throws Exception {
    switch (obstacle_type) {
      case "rectangle":
        return new org.team2363.helixtrajectory.Obstacle(
            safety_distance,
            true,
            List.of(
                new ObstaclePoint(center_x - length / 2, center_y - width / 2),
                new ObstaclePoint(center_x + length / 2, center_y - width / 2),
                new ObstaclePoint(center_x + length / 2, center_y + width / 2),
                new ObstaclePoint(center_x - length / 2, center_y + width / 2)));
      default:
        throw new Exception(String.format("Not Implemented: %s", obstacle_type));
    }
  }
}
