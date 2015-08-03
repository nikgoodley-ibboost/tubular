## Command-line interface ##

_TODO_

```
usage: java -jar tubular-cli.jar [-b <name=uri>] [-h] [-l <uri>] [-o
       <name=value>] [-p <name=value>] [-v] [-V] -x <uri>
 -b,--port-binding <name=uri>   Binds a source port to the specified URI
 -h,--help                      Print help
 -l,--library <uri>             XProc pipeline library to load
 -o,--option <name=value>       Passes an option to the pipeline
 -p,--param <name=value>        Passes a parameter to the pipeline
 -v,--verbose                   Display more information
 -V,--version                   Print version and exit
 -x,--xpl <uri>                 XProc pipeline to load and run
```

## Embedding Tubular in a Java application ##

### Maven configuration ###

To add Tubular to your [Maven](http://maven.apache.org/) project, add the following to the POM:

```
  ...

  <repositories>

    <repository>
      <id>snapshots.trancecode.org</id>
      <url>http://maven.trancecode.org/snapshots/</url>
    </repository>

  </repositories>

  ...

  <dependencies>

    ...

    <dependency>
      <groupId>org.trancecode</groupId>
      <artifactId>tubular-core</artifactId>
      <version>0.1.0-SNAPSHOT</version>
    </dependency>

    ...

  </dependencies>

  ...
```

You'll need to add a [tc-logging](http://code.google.com/p/tc-logging/) provider depending on the logging API you are using in your application. See [tc-logging manual](http://code.google.com/p/tc-logging/wiki/Manual) for further details.

### Parsing and running a pipeline ###

The main entry point in Tubular API is the [PipelineProcessor](http://static.trancecode.org/api/org.trancecode/tubular/0.1.0-SNAPSHOT/org/trancecode/xproc/PipelineProcessor.html).
```
// Create a processor
PipelineProcessor processor = new PipelineProcessor();

// Parse the pipeline source
Source pipelineSource = new StreamSource("file:///path/to/pipeline.xpl");
Pipeline pipeline = processor.buildPipeline(pipelineSource);

// "Load" the pipeline into an executable pipeline
RunnablePipeline runnablePipeline = pipeline.load();

// Set options and bind ports
runnablePipeline.withOption(new QName("my-option"), "some option value");
runnablePipeline.withParam(new QName("my-parameter"), "some parameter value");
runnablePipeline.bindSourcePort("source", new StreamSource("file:///path/to/source-document.xml"));

// Run the pipeline
PipelineResult result = runnablePipeline.run();

// Retrieve the nodes from the 'result' port as Saxon nodes
Iterable<XdmNode> resultNodes = result.readNodes("result");

// Write the nodes from the 'result' port to a Result
result.readNode("result", new StreamResult("file:///path/to/result.xml"));

// Write the nodes from the 'result' port to an output file
result.readNode("result", new File("/path/to/result.xml"));
```