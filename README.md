# List Utilities

Herein are a number of Java methods where I had use of the functionality they would provide. Rather than using copy-and-paste—or worse, remaking the method from scratch—every time I needed to use one of these, I put them in a library, and made them as generic as I could.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Requires Java 8 or greater. Recompiling from source may allow for earlier versions, but such versions are not supported.

### Installing

To use this library (or any third-party package, for that matter) you must add the JAR file (ListUtils-x.y.z.jar) to your CLASSPATH. There are several ways to accomplish this:

 1. If you are using an IDE, it will likely include a method. Here are links to instructions for some common IDEs:
     - [Eclipse](https://javarevisited.blogspot.com/2016/07/eclipse-how-to-add-external-jar-into-classpath.html)
     - [NetBeans](https://netbeans.org/kb/74/java/project-setup.html#projects-classpath)
     - [Intellij IDEA](https://www.jetbrains.com/help/idea/library.html)
 2. Modify your system's CLASSPATH environment variable, creating it if it does not already exist.
 3. Use the -classpath java or javac command-line argument, e.g.
    ```
    java -classpath C:\java\thirdpartjars\thirdparty.jar MyProgram
    ```
## Tests

There is currently no automated testing.

## Documentation

Included in the target/site/apidocs/ folder is the javadoc for this library.

## Built With

* [NetBeans](https://netbeans.org/)—The IDE used
* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Please read [CONTRIBUTING.md](https://github.com/Script-Mak3r/list-utilities-library/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [Semantic Versioning](https://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/Script-Mak3r/list-utilities-library/tags), or see the [changelog](CHANGELOG.md).

## Authors

* **Script Mak3r**—*Initial work*—[Script Mak3r](https://github.com/Script-Mak3r)

See also the list of [contributors](https://github.com/Script-Mak3r/list-utilities-library/contributors) who participated in this project.

## License

This project is licensed under the GNU Lesser General Public License version 3.0, albeit with a linking exception—see the [LICENSE](LICENSE) file for details.

## Acknowledgments

* **Billie Thompson**—*README and CONTRIBUTING templates*—[PurpleBooth](https://github.com/PurpleBooth)
* **A number of people on Stack Overflow**—*Questions and answers that contained helpful information*—[Stack Overflow](https://stackoverflow.com/)
