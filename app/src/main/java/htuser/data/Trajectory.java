package htuser.data;

import java.util.ArrayList;
import java.util.List;
import org.team2363.helixtrajectory.HolonomicTrajectory;

public class Trajectory {
  public final List<TrajectorySample> samples;

  public Trajectory(HolonomicTrajectory ht) {
    samples = new ArrayList<>();

    double timestamp = 0;
    for (var segment : ht.holonomicSegments) {
      for (var sample : segment.holonomicSamples) {
        timestamp += sample.intervalDuration;
        samples.add(new TrajectorySample(sample, timestamp));
      }
    }
  }
}
