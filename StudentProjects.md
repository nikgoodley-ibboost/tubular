# Introduction #

This page is a list of projects that could be handled by students as part of their University course.

### How will this happen? ###

  * The students will have their own source code repository (see DeveloperManual) and workspace on a provided [continuous integration server](http://ci.trancecode.org/jenkins/).
  * They can ask questions over the [developer mailing list](http://groups.google.com/group/tubular-developer) of the project.
  * When the students think their code is in good shape and meet the quality requirements of the project, they will request a merge into the main branch. After reviewing the code, I will perform the merge.
  * The license of the project is LGPL. Please be sure this complies with any specific requirement or rule in effect at your University.

### What's the point for students? ###

  * It's an opportunity to work with tools that are used in enterprise: Apache Maven, TestNG, Mercurial, Jenkins.
  * It's a good way to do something out of the ordinary while at the University. I've been both a student and a teacher at the University and every year students were striving for unusual project that would not turn out to be "yet another brute-force prime factorization tool".
  * Open source contributions are a big plus in a resume if you want to be a software developer. At least it is the case in the [company I work at](http://www.componize.com/careers/).
  * At [Componize Software](http://www.componize.com) (the company I work at) we are always looking for new talents. Succeeding with this student project is a good way to get an internship or a job here.

### What's the point for teachers? ###

  * It's a cool new idea to motivate students
  * Less time spent on code review: I will have to review the student code myself before I pull it into the main branch. I am a code quality maniac so I will only pull correct code.

### How to apply? ###

Just contact me: herve.quiroz@trancecode.org

# Project 1: Document Templating Steps for XProc #

Two new steps have been added to the standard library after the [XProc 1.0 W3C Recommendation](http://www.w3.org/TR/xproc/) has been released in May 2010:

  * `p:in-scope-names`
  * `p:template`

The objective of this project is to implement these two steps.

http://www.w3.org/TR/xproc-template/

# Project 2: EXProc #

The [exproc.org](http://exproc.org/) website has been established as a place where custom, community-approved steps and extension functions can be cataloged and, where practical, made interoperable. There are already a number of such extension proposals that have been submitted. The objective of this project is to implement some of these steps and functions.

http://exproc.org/