/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/**
 *  The implementation of the javadoc tool, and associated doclets.
 *
 *  <p>Internally, javadoc is composed of two primary parts:
 *  the {@link jdk.javadoc.internal.tool tool}, and a series of
 *  {@link jdk.javadoc.internal.doclets doclets}.
 *
 *  The tool provides a common infrastructure for command-line processing,
 *  and for reading the documentation comments in Java source files,
 *  while doclets provide a user-selectable backend for determining
 *  how to process the documentation comments.
 *
 *  <p><em>Historical Note:</em> Prior to the introduction of the
 *  {@link javax.lang.model Language Model API} in JDK 6, it was
 *  not unusual to use the {@link com.sun.javadoc} API as a
 *  modeling API. But the Language Model API, and associated
 *  {@link javax.annotation.processing Annotation Processing API}
 *  provided a better way to model programs, and in JDK 9,
 *  javadoc itself was converted to using the Language Model API,
 *  with the {@code com.sun.javadoc API} being deprecated for
 *  eventual removal.
 *  </p>
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
package jdk.javadoc.internal;
