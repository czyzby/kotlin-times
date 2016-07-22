package kt.times

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

/**
 * Tests [times] extension functions. Tests every possible input, resulting in a rather long compiling and running
 * times. Note that since * operator is basically syntax sugar for "times", * operator method variants are not tested.
 * @author MJ
 */
class KotlinTimesTest {
  @Test
  fun shouldRunValidAmountOfTimesForAnyGivenByte() {
    for (any in Byte.MIN_VALUE..Byte.MAX_VALUE) {
      val expectedRuns = if (any > 0) any else 0
      var runs = 0
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  fun shouldReportValidIterationIndexForAnyGivenByte() {
    for (any in Byte.MIN_VALUE..Byte.MAX_VALUE) {
      var expectedIndex = 0
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }

  @Test
  fun shouldRunValidAmountOfTimesForAnyGivenShort() {
    for (any in Short.MIN_VALUE..Short.MAX_VALUE) {
      val expectedRuns = if (any > 0) any else 0
      var runs = 0
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  fun shouldReportValidIterationIndexForAnyGivenShort() {
    for (any in Short.MIN_VALUE..Short.MAX_VALUE) {
      var expectedIndex = 0
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }

  @Test
  @Ignore
  fun shouldRunValidAmountOfTimesForAnyGivenInteger() {
    for (any in Int.MIN_VALUE..Int.MAX_VALUE) {
      val expectedRuns = if (any > 0) any else 0
      var runs = 0
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  @Ignore
  fun shouldReportValidIterationIndexForAnyGivenInteger() {
    for (any in Int.MIN_VALUE..Int.MAX_VALUE) {
      var expectedIndex = 0
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }

  @Test
  @Ignore
  fun shouldRunValidAmountOfTimesForAnyGivenLong() {
    for (any in Long.MIN_VALUE..Long.MAX_VALUE) {
      val expectedRuns = if (any > 0L) any else 0L
      var runs = 0L
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  @Ignore
  fun shouldReportValidIterationIndexForAnyGivenLong() {
    for (any in Long.MIN_VALUE..Long.MAX_VALUE) {
      var expectedIndex = 0L
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }


  @Test
  fun shouldRunValidAmountOfTimesForEdgeCaseIntegers() {
    for (any in intArrayOf(Int.MIN_VALUE, 0, 1, Int.MAX_VALUE)) {
      val expectedRuns = if (any > 0) any else 0
      var runs = 0
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  fun shouldReportValidIterationIndexForEdgeCaseIntegers() {
    for (any in intArrayOf(Int.MIN_VALUE, 0, 1, Int.MAX_VALUE)) {
      var expectedIndex = 0
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }

  @Test
  @Ignore
  fun shouldRunValidAmountOfTimesForEdgeCaseLongs() {
    for (any in longArrayOf(Long.MIN_VALUE, 0L, 1L, Long.MAX_VALUE)) {
      val expectedRuns = if (any > 0L) any else 0L
      var runs = 0L
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  @Ignore
  fun shouldReportValidIterationIndexForEdgeCaseLongs() {
    for (any in longArrayOf(Long.MIN_VALUE, 0L, 1L, Long.MAX_VALUE)) {
      var expectedIndex = 0L
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }

  @Test
  fun shouldRunValidAmountOfTimesForGoodEnoughLongs() {
    for (any in longArrayOf(Long.MIN_VALUE, 0L, 1L, 100000L)) {
      val expectedRuns = if (any > 0L) any else 0L
      var runs = 0L
      any times {
        runs++
      }
      assertEquals(expectedRuns, runs)
    }
  }

  @Test
  fun shouldReportValidIterationIndexForGoodEnoughLongs() {
    for (any in longArrayOf(Long.MIN_VALUE, 0L, 1L, 100000L)) {
      var expectedIndex = 0L
      any times {
        assertEquals(expectedIndex, it)
        expectedIndex++
      }
    }
  }
}
