# JRack

A lightweight **Rack** port for the Java Servlet environment, forked from the original [JRack](https://sourceforge.net/projects/approvaltests/files/).

For more information on **Rack**, visit http://rack.github.io.

# Build

    mvn install
or:

    mvn install -Dmaven.test.skip=true


# Maven distribution hosted on [Github](https://github.com/florinpatrascu/jrack/tree/mvn-repo)

Just add these to your __pom.xml__ file:

```xml
      <dependency>
        <groupId>org.jrack</groupId>
        <artifactId>jrack</artifactId>
        <version>2.0.2</version>
      </dependency>
```

### Submitting an Issue
We use the [GitHub issue tracker](https://github.com/florinpatrascu/jrack/issues) to track bugs and features. Before submitting a bug report or feature request, check to make sure it hasn't already been submitted. When submitting a bug report, please include a [Gist](https://gist.github.com/) that includes a stack trace and any other details that may be necessary to reproduce the bug, including your Java version and operating system. Ideally, a bug report should include a pull request with failing specs.


### License

   Copyright (c) 2012-2014 Florin T.Pătraşcu

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

