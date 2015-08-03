# Requirements #

  * Eclipse 3.7+
  * Java 1.6+
  * Apache Maven 3+ (optional but it is strongly required to have the command-line tool installed)

# Importing root project into Eclipse #

  * _File_ / _New_ / _Project..._
  * In _Mercurial_, select _Clone existing Mercurial Repository_
  * URL for the main repository can be found [on this Web site](http://code.google.com/p/tubular/source/checkout) or you can use the URL of your own clone if you plan to contribute to the project
  * Click _Next_ twice and then _Finish_

You should have a project named @tubular@ in your workspace. This is the project from which you can check if your working copy is up to date and perform push and pull operations.

# Importing a specific module into Eclipse #

This operation requires the root project to be imported into Eclipse beforehand.

  * _File_ / _Import..._
  * In _General_, select _Existing project into Workspace_
  * In _Select root directory_, click _Browse..._ and select the directory from the Tubular repository (previously cloned) which contains the module you wish to import
  * Make sure that the _Copy projects into Workspace_ option is **not** enabled
  * Click _Finish_

# Troubleshooting #

## If you have missing dependencies ##

This is where the command-line Maven will come handy.

  * Open a command-line terminal
  * Reach the directory that contains the module Eclipse is complaining about
  * Type the following command:
```
$ mvn dependency:resolve
```
  * Back in Eclipse, refresh your project
  * You might also need to run the _Update dependencies..._ action from the _Maven_ section in the contextual menu of the module