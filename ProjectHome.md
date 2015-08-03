Tubular is a Java implementation of an [XProc](http://www.w3.org/TR/xproc/) pipeline processor.

An XML Pipeline specifies a sequence of operations to be performed on zero or more XML documents. Pipelines generally accept zero or more XML documents as input and produce zero or more XML documents as output. Pipelines are made up of simple steps which perform atomic operations on XML documents and constructs similar to conditionals, iteration, and exception handlers which control which steps are executed.

Tubular is implemented with as much immutable objects as possible, in order to facilitate the addition of [parallelism support](ParallelProcessing.md) by reducing the need for locking mechanisms. The project enforces a functional-programming approach and the code is based on the functional code blocks from Google Collections (predicates, functions and suppliers).

This XProc implementation is validated against the [test suite](http://tests.xproc.org/) from [XProc.org](http://xproc.org). The test suite results are [publicly available](http://tests.xproc.org/results/tubular/).

&lt;wiki:gadget url="http://www.ohloh.net/p/268108/widgets/project\_basic\_stats.xml" height="250" width="400" border="0"/&gt;