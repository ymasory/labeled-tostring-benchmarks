# labeled-tostring-benchmarks #
## Overview ##
Some benchmarks for the [labeled-tostring project](https://github.com/ymasory/labeled-tostring). Uses [caliper](http://code.google.com/p/caliper/) and sirthias's awesome [Scala benchmarking template](https://github.com/sirthias/scala-benchmarking-template).

## Run ##

    cd labeled-tostring-benchmarks
    ./sbt run

Don't worry about the `SecurityExceptions`, they're normal. We use the `SecurityManager` to prevent caliper from succeeding in its `System.exit` calls. If you get a different error just run `sbt update` and `sbt run` again.
