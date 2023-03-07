# helix-trajectory-app

A basic reimplementation of [HelixNavigator](https://github.com/TripleHelixProgramming/HelixNavigator)'s interface with [HelixTrajectory/TrajoptLib](https://github.com/SleipnirGroup/TrajoptLib).

## Description

This is intended as a tool to be used alongside HelixNavigator, to generate trajectories separately from the tool itself, and export them in bulk.

## Getting Started

### Dependencies

* Docker

### Installing

* [Docker Repository](https://hub.docker.com/r/jlmcmchl/helix-trajectory-app)

### Executing program

This tool expects a folder mounted at `/data`, where a HelixNavigator project file should be placed.

```sh
docker run -v "$(pwd)"/data:/data jlmcmchl/helix-trajectory-app:1.0.1 <args>
```

## Help

This application expects 1 or 2 arguments:

1. HelixNavigator project file name
2. HelixNavigator path name (or `all`)
    * if `all` is provided instead, trajectories will be generated from all paths.

This information can also be found by providing 0 arguments:

```sh
docker run jlmcmchl/helix-trajectory-app:1.0.1
```

## Authors

* Jordan McMichael

## Version History

* 1.0.1
  * Add License, README
  * Remove default `project.json` from ENTRYPOINT
* 1.0
  * Initial Release

## License

This project is licensed under the MIT License - see the LICENSE file for details

## Acknowledgments

* [HelixNavigator](https://github.com/TripleHelixProgramming/HelixNavigator)
* [HelixTrajectory/TrajoptLib](https://github.com/SleipnirGroup/TrajoptLib)
