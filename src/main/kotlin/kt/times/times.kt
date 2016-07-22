package kt.times

/**
 * Allows to repeat an action N times, where N is a [Byte] value on which this method is invoked. Since this method is
 * marked as inline, there should be no runtime overhead of using this method over simple range iteration (or its Java
 * for-loop equivalent, for that matter).
 * @param action its invocations amount will be equal to this [Byte] value. If the value is 0 or negative, this action
 *    will not be invoked. It consumes current iteration index, starting from 0 and ending with (value-1).
 */
inline infix operator fun Byte.times(action: (Byte) -> Unit) {
  var i: Byte = 0
  while (i < this) action(i++)
}

/**
 * Allows to repeat an action N times, where N is a [Short] value on which this method is invoked. Since this method is
 * marked as inline, there should be no runtime overhead of using this method over simple range iteration (or its Java
 * for-loop equivalent, for that matter).
 * @param action its invocations amount will be equal to this [Short] value. If the value is 0 or negative, this action
 *    will not be invoked. It consumes current iteration index, starting from 0 and ending with (value-1).
 */
inline infix operator fun Short.times(action: (Short) -> Unit) {
  var i: Short = 0
  while (i < this) action(i++)
}

/**
 * Allows to repeat an action N times, where N is an [Int] value on which this method is invoked. Since this method is
 * marked as inline, there should be no runtime overhead of using this method over simple range iteration (or its Java
 * for-loop equivalent, for that matter).
 * @param action its invocations amount will be equal to this [Int] value. If the value is 0 or negative, this action
 *    will not be invoked. It consumes current iteration index, starting from 0 and ending with (value-1).
 */
inline infix operator fun Int.times(action: (Int) -> Unit) {
  var i = 0
  while (i < this) action(i++)
}

/**
 * Allows to repeat an action N times, where N is a [Long] value on which this method is invoked. Since this method is
 * marked as inline, there should be no runtime overhead of using this method over simple range iteration (or its Java
 * for-loop equivalent, for that matter).
 * @param action its invocations amount will be equal to this [Long] value. If the value is 0 or negative, this action
 *    will not be invoked. It consumes current iteration index, starting from 0 and ending with (value-1).
 */
inline infix operator fun Long.times(action: (Long) -> Unit) {
  var i = 0L
  while (i < this) action(i++)
}
