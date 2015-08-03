### Parallel processing ###

  * Uses immutable data structures in order to avoid the need for locks
  * Uses a thread pool executor to process `p:for-each` iterations in parallel
  * Uses a thread pool executor to execute sub-pipeline steps in parallel

_Parallel processing mechanisms are explained on a [dedicated page](ParallelProcessing.md)._

### Saxon s9api-based ###

  * Fast, efficient XML data model
  * XPath 2.0
  * XSLT 2.0

### Code style ###

  * Uses functional programming constructs (based on [Google Guava](http://code.google.com/p/guava-libraries/))

### Test-driven development ###

  * Processor is validated against the [XProc test suite](http://tests.xproc.org/)
  * Results are public: http://tests.xproc.org/results/tubular/

### XML APIs friendly ###

  * Tubular makes use of standard Java API for XML Processing ([JAXP](http://en.wikipedia.org/wiki/Java_API_for_XML_Processing))
  * Resource content is retrieved through standard mechanisms, e.g. [URIResolver](http://download.oracle.com/javase/6/docs/api/javax/xml/transform/URIResolver.html) or [EntityResolver](http://download.oracle.com/javase/6/docs/api/org/xml/sax/EntityResolver.html)
  * It makes Tubular easily embeddable within CMS systems

### Open source ###

  * Tubular is licensed under LGPL
  * Contributions are welcome (see [the list of contributors](Contributors.md))