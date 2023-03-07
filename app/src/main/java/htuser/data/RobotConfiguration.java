package htuser.data;

import java.util.List;
import org.team2363.helixtrajectory.ObstaclePoint;
import org.team2363.helixtrajectory.SwerveDrivetrain;
import org.team2363.helixtrajectory.SwerveModule;

public class RobotConfiguration {
  public double bumper_length;
  public double bumper_width;
  public double mass;
  public double moment_of_inertia;
  public double motor_max_angular_speed;
  public double motor_max_torque;
  public double team_number;
  public double wheel_horizontal_distance;
  public double wheel_radius;
  public double wheel_vertical_distance;

  public SwerveDrivetrain toDrivetrain() {
    return new SwerveDrivetrain(
        mass,
        moment_of_inertia,
        List.of(
            new SwerveModule(
                +wheel_horizontal_distance,
                +wheel_vertical_distance,
                wheel_radius,
                motor_max_angular_speed,
                motor_max_torque),
            new SwerveModule(
                +wheel_horizontal_distance,
                -wheel_vertical_distance,
                wheel_radius,
                motor_max_angular_speed,
                motor_max_torque),
            new SwerveModule(
                -wheel_horizontal_distance,
                +wheel_vertical_distance,
                wheel_radius,
                motor_max_angular_speed,
                motor_max_torque),
            new SwerveModule(
                -wheel_horizontal_distance,
                -wheel_vertical_distance,
                wheel_radius,
                motor_max_angular_speed,
                motor_max_torque)),
        new org.team2363.helixtrajectory.Obstacle(
            0,
            true,
            List.of(
                new ObstaclePoint(+bumper_length / 2, +bumper_width / 2),
                new ObstaclePoint(-bumper_length / 2, +bumper_width / 2),
                new ObstaclePoint(-bumper_length / 2, -bumper_width / 2),
                new ObstaclePoint(+bumper_length / 2, -bumper_width / 2))));
  }
}
