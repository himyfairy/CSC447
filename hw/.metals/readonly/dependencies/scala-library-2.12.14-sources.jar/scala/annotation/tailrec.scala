/*
 * Scala (https://www.scala-lang.org)
 *
 * Copyright EPFL and Lightbend, Inc.
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package scala.annotation

/** A method annotation which verifies that the method will be compiled
 *  with tail call optimization.
 *
 *  If it is present, the compiler will issue an error if the method cannot
 *  be optimized into a loop.
 *
 *  @since 2.8
 */
final class tailrec extends StaticAnnotation
