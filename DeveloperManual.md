This page describes the internal API of Tubular. With the following information, you will be able to develop new step processors or XPath extension functions. In turn this will allow you to either contribute to Tubular or write your own XProc custom steps.

## Basics ##

Most extensions in Tubular are discovered through standard Java 1.6 [ServiceLoader](http://download.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html) mechanism. Even standard XProc [step processors](http://www.w3.org/TR/xproc/#std-components) and [XPath extension functions](http://www.w3.org/TR/xproc/#xpath-extension-functions) are provided through this mechanism.

### Contributing to the project ###

All kind of contributions are currently accepted. This includes:

  * bug fixes
  * new steps and XPath extension functions
  * documentation (Wiki)

The [list of contributors](Contributors.md) is available as a separate page on this Wiki.

To contribute to Tubular source code, you may [create your own clone of the source tree](http://code.google.com/p/support/wiki/MercurialFAQ#Why_should_I_create_a_server-side_clone?). There are strict rules regarding code style conventions and source code formatting. If you are using Eclipse as your IDE, these rules will be enforced by the editor itself.

## Tubular API extension points ##

### Developing a new step processor ###

_TODO_

#### Useful API links ####

  * [AbstractStepProcessor](http://static.trancecode.org/api/org.trancecode/tubular/0.1.0-SNAPSHOT/org/trancecode/xproc/step/AbstractStepProcessor.html)
  * [StepInput](http://static.trancecode.org/api/org.trancecode/tubular/0.1.0-SNAPSHOT/org/trancecode/xproc/step/AbstractStepProcessor.StepInput.html)
  * [StepOutput](http://static.trancecode.org/api/org.trancecode/tubular/0.1.0-SNAPSHOT/org/trancecode/xproc/step/AbstractStepProcessor.StepOutput.html)

#### Examples ####

  * [p:identity](http://ci.trancecode.org/jenkins/job/tubular/ws/tubular-core/target/site/xref/org/trancecode/xproc/step/IdentityStepProcessor.html)
  * [p:count](http://ci.trancecode.org/jenkins/job/tubular/ws/tubular-core/target/site/xref/org/trancecode/xproc/step/CountStepProcessor.html)

### Developing a new XPath extension function ###

_TODO_

#### Useful API links ####

  * [AbstractXPathExtensionFunction](http://static.trancecode.org/api/org.trancecode/tubular/0.1.0-SNAPSHOT/org/trancecode/xproc/xpath/AbstractXPathExtensionFunction.html)

#### Examples ####

  * [p:system-property()](http://ci.trancecode.org/jenkins/job/tubular/ws/tubular-core/target/site/xref/org/trancecode/xproc/xpath/SystemPropertyXPathExtensionFunction.html)
  * [p:step-available()](http://ci.trancecode.org/jenkins/job/tubular/ws/tubular-core/target/site/xref/org/trancecode/xproc/xpath/StepAvailableXPathExtensionFunction.html)