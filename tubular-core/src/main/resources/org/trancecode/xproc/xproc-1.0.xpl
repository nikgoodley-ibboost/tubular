<?xml version="1.0" encoding="UTF-8"?>
<p:library xmlns:p="http://www.w3.org/ns/xproc">
   <p:declare-step type="p:add-attribute" xml:id="add-attribute">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
      <p:option name="attribute-name" required="true"/>
      <p:option name="attribute-value" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:add-xml-base" xml:id="add-xml-base">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="all" select="'false'"/>
      <p:option name="relative" select="'true'"/>
   </p:declare-step>
   <p:declare-step type="p:compare" xml:id="compare">
      <p:input port="source" primary="true"/>
      <p:input port="alternate"/>
      <p:output port="result" primary="false"/>
      <p:option name="fail-if-not-equal" select="'false'"/>
   </p:declare-step>
   <p:declare-step type="p:count" xml:id="count">
      <p:input port="source" sequence="true"/>
      <p:output port="result"/>
      <p:option name="limit" select="0"/>
   </p:declare-step>
   <p:declare-step type="p:delete" xml:id="delete">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:directory-list" xml:id="directory-list">
      <p:output port="result"/>
      <p:option name="path" required="true"/>
      <p:option name="include-filter"/>
      <p:option name="exclude-filter"/>
   </p:declare-step>
   <p:declare-step type="p:error" xml:id="error">
      <p:input port="source" primary="false"/>
      <p:option name="code" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:escape-markup" xml:id="escape-markup">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="cdata-section-elements" select="''"/>
      <p:option name="doctype-public"/>
      <p:option name="doctype-system"/>
      <p:option name="escape-uri-attributes" select="'false'"/>
      <p:option name="include-content-type" select="'true'"/>
      <p:option name="indent" select="'false'"/>
      <p:option name="media-type"/>
      <p:option name="method" select="'xml'"/>
      <p:option name="omit-xml-declaration" select="'true'"/>
      <p:option name="standalone" select="'omit'"/>
      <p:option name="undeclare-prefixes"/>
      <p:option name="version" select="'1.0'"/>
   </p:declare-step>
   <p:declare-step type="p:filter" xml:id="filter">
      <p:input port="source"/>
      <p:output port="result" sequence="true"/>
      <p:option name="select" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:http-request" xml:id="http-request">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="byte-order-mark"/>
      <p:option name="cdata-section-elements" select="''"/>
      <p:option name="doctype-public"/>
      <p:option name="doctype-system"/>
      <p:option name="encoding"/>
      <p:option name="escape-uri-attributes" select="'false'"/>
      <p:option name="include-content-type" select="'true'"/>
      <p:option name="indent" select="'false'"/>
      <p:option name="media-type"/>
      <p:option name="method" select="'xml'"/>
      <p:option name="normalization-form" select="'none'"/>
      <p:option name="omit-xml-declaration" select="'true'"/>
      <p:option name="standalone" select="'omit'"/>
      <p:option name="undeclare-prefixes"/>
      <p:option name="version" select="'1.0'"/>
   </p:declare-step>
   <p:declare-step type="p:identity" xml:id="identity">
      <p:input port="source" sequence="true"/>
      <p:output port="result" sequence="true"/>
   </p:declare-step>
   <p:declare-step type="p:insert" xml:id="insert">
      <p:input port="source" primary="true"/>
      <p:input port="insertion" sequence="true"/>
      <p:output port="result"/>
      <p:option name="match" select="'/*'"/>
      <p:option name="position" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:label-elements" xml:id="label-elements">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="attribute" select="'xml:id'"/>
      <p:option name="label" select="'concat(&#34;_&#34;,$p:index)'"/>
      <p:option name="match" select="'*'"/>
      <p:option name="replace" select="'true'"/>
   </p:declare-step>
   <p:declare-step type="p:load" xml:id="load">
      <p:output port="result"/>
      <p:option name="href" required="true"/>
      <p:option name="dtd-validate" select="'false'"/>
   </p:declare-step>
   <p:declare-step type="p:make-absolute-uris" xml:id="make-absolute-uris">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
      <p:option name="base-uri"/>
   </p:declare-step>
   <p:declare-step type="p:namespace-rename" xml:id="namespace-rename">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="from"/>
      <p:option name="to"/>
      <p:option name="apply-to" select="'all'"/>
   </p:declare-step>
   <p:declare-step type="p:pack" xml:id="pack">
      <p:input port="source" sequence="true" primary="true"/>
      <p:input port="alternate" sequence="true"/>
      <p:output port="result" sequence="true"/>
      <p:option name="wrapper" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:parameters" xml:id="parameters">
      <p:input port="parameters" kind="parameter" primary="false"/>
      <p:output port="result" primary="false"/>
   </p:declare-step>
   <p:declare-step type="p:rename" xml:id="rename">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
      <p:option name="new-name" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:replace" xml:id="replace">
      <p:input port="source" primary="true"/>
      <p:input port="replacement"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:set-attributes" xml:id="set-attributes">
      <p:input port="source" primary="true"/>
      <p:input port="attributes"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:sink" xml:id="sink">
      <p:input port="source" sequence="true"/>
   </p:declare-step>
   <p:declare-step type="p:split-sequence" xml:id="split-sequence">
      <p:input port="source" sequence="true"/>
      <p:output port="matched" sequence="true" primary="true"/>
      <p:output port="not-matched" sequence="true"/>
      <p:option name="initial-only" select="'false'"/>
      <p:option name="test" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:store" xml:id="store">
      <p:input port="source"/>
      <p:output port="result" primary="false"/>
      <p:option name="href" required="true"/>
      <p:option name="byte-order-mark"/>
      <p:option name="cdata-section-elements" select="''"/>
      <p:option name="doctype-public"/>
      <p:option name="doctype-system"/>
      <p:option name="encoding"/>
      <p:option name="escape-uri-attributes" select="'false'"/>
      <p:option name="include-content-type" select="'true'"/>
      <p:option name="indent" select="'false'"/>
      <p:option name="media-type"/>
      <p:option name="method" select="'xml'"/>
      <p:option name="normalization-form" select="'none'"/>
      <p:option name="omit-xml-declaration" select="'true'"/>
      <p:option name="standalone" select="'omit'"/>
      <p:option name="undeclare-prefixes"/>
      <p:option name="version" select="'1.0'"/>
   </p:declare-step>
   <p:declare-step type="p:string-replace" xml:id="string-replace">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
      <p:option name="replace" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:unescape-markup" xml:id="unescape-markup">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="namespace"/>
      <p:option name="content-type" select="'application/xml'"/>
      <p:option name="encoding"/>
      <p:option name="charset"/>
   </p:declare-step>
   <p:declare-step type="p:unwrap" xml:id="unwrap">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:wrap" xml:id="wrap">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="wrapper" required="true"/>
      <p:option name="match" required="true"/>
      <p:option name="group-adjacent"/>
   </p:declare-step>
   <p:declare-step type="p:wrap-sequence" xml:id="wrap-sequence">
      <p:input port="source" sequence="true"/>
      <p:output port="result" sequence="true"/>
      <p:option name="wrapper" required="true"/>
      <p:option name="group-adjacent"/>
   </p:declare-step>
   <p:declare-step type="p:xinclude" xml:id="xinclude">
      <p:input port="source"/>
      <p:output port="result"/>
      <p:option name="fixup-xml-base" select="'false'"/>
      <p:option name="fixup-xml-lang" select="'false'"/>
   </p:declare-step>
   <p:declare-step type="p:xslt" xml:id="xslt">
      <p:input port="source" sequence="true" primary="true"/>
      <p:input port="stylesheet"/>
      <p:input port="parameters" kind="parameter"/>
      <p:output port="result" primary="true"/>
      <p:output port="secondary" sequence="true"/>
      <p:option name="initial-mode"/>
      <p:option name="template-name"/>
      <p:option name="output-base-uri"/>
      <p:option name="version"/>
   </p:declare-step>
   <p:declare-step type="p:exec" xml:id="exec">
      <p:input port="source" primary="true" sequence="true"/>
      <p:output port="result" primary="true"/>
      <p:output port="errors"/>
      <p:option name="command" required="true"/>
      <p:option name="args" select="''"/>
      <p:option name="cwd"/>
      <p:option name="source-is-xml" select="'true'"/>
      <p:option name="result-is-xml" select="'true'"/>
      <p:option name="wrap-result-lines" select="'false'"/>
      <p:option name="errors-is-xml" select="'false'"/>
      <p:option name="wrap-error-lines" select="'false'"/>
      <p:option name="fix-slashes" select="'false'"/>
      <p:option name="byte-order-mark"/>
      <p:option name="cdata-section-elements" select="''"/>
      <p:option name="doctype-public"/>
      <p:option name="doctype-system"/>
      <p:option name="encoding"/>
      <p:option name="escape-uri-attributes" select="'false'"/>
      <p:option name="include-content-type" select="'true'"/>
      <p:option name="indent" select="'false'"/>
      <p:option name="media-type"/>
      <p:option name="method" select="'xml'"/>
      <p:option name="normalization-form" select="'none'"/>
      <p:option name="omit-xml-declaration" select="'true'"/>
      <p:option name="standalone" select="'omit'"/>
      <p:option name="undeclare-prefixes"/>
      <p:option name="version" select="'1.0'"/>
   </p:declare-step>
   <p:declare-step type="p:hash" xml:id="hash">
      <p:input port="source" primary="true"/>
      <p:output port="result"/>
      <p:input port="parameters" kind="parameter"/>
      <p:option name="value" required="true"/>
      <p:option name="algorithm" required="true"/>
      <p:option name="match" required="true"/>
      <p:option name="version"/>
   </p:declare-step>
   <p:declare-step type="p:uuid" xml:id="uuid">
      <p:input port="source" primary="true"/>
      <p:output port="result"/>
      <p:option name="match" required="true"/>
      <p:option name="version"/>
   </p:declare-step>
   <p:declare-step type="p:validate-with-relax-ng" xml:id="validate-with-relax-ng">
      <p:input port="source" primary="true"/>
      <p:input port="schema"/>
      <p:output port="result"/>
      <p:option name="dtd-attribute-values" select="'false'"/>
      <p:option name="dtd-id-idref-warnings" select="'false'"/>
      <p:option name="assert-valid" select="'true'"/>
   </p:declare-step>
   <p:declare-step type="p:validate-with-schematron" xml:id="validate-with-schematron">
      <p:input port="parameters" kind="parameter"/>
      <p:input port="source" primary="true"/>
      <p:input port="schema"/>
      <p:output port="result" primary="true"/>
      <p:output port="report" sequence="true"/>
      <p:option name="phase" select="'#ALL'"/>
      <p:option name="assert-valid" select="'true'"/>
   </p:declare-step>
   <p:declare-step type="p:validate-with-xml-schema" xml:id="validate-with-xml-schema">
      <p:input port="source" primary="true"/>
      <p:input port="schema" sequence="true"/>
      <p:output port="result"/>
      <p:option name="use-location-hints" select="'false'"/>
      <p:option name="try-namespaces" select="'false'"/>
      <p:option name="assert-valid" select="'true'"/>
      <p:option name="mode" select="'strict'"/>
   </p:declare-step>
   <p:declare-step type="p:www-form-urldecode" xml:id="www-form-urldecode">
      <p:output port="result"/>
      <p:option name="value" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:www-form-urlencode" xml:id="www-form-urlencode">
      <p:input port="source" primary="true"/>
      <p:output port="result"/>
      <p:input port="parameters" kind="parameter"/>
      <p:option name="match" required="true"/>
   </p:declare-step>
   <p:declare-step type="p:xquery" xml:id="xquery">
      <p:input port="source" sequence="true" primary="true"/>
      <p:input port="query"/>
      <p:input port="parameters" kind="parameter"/>
      <p:output port="result" sequence="true"/>
   </p:declare-step>
   <p:declare-step type="p:xsl-formatter" xml:id="xsl-formatter">
      <p:input port="source"/>
      <p:input port="parameters" kind="parameter"/>
      <p:output port="result" primary="false"/>
      <p:option name="href" required="true"/>
      <p:option name="content-type"/>
   </p:declare-step>
</p:library>