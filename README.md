```
____________________________________________________
|     ____  __.      __  .__  .__                  |
|    |    |/ _|_____/  |_|  | |__| ____   07/2016  |
|    |      / /  _ \   __\  | |  |/    \           |
|    |    | \(  (_} )  | |  |_|  |   |  \          |
|    |____|__ \____/|__| |____/__|___|  /          |
|            \/                       \/           |
|            __  .__                               |
|          _/  |_|__| _____   ____   ______        |
|          \   __\  |/     \_/ __ \ /  ___/        |
|           |  | |  |  Y Y  \  ___/ \___ \         |
|           |__| |__|__|_|  /\___  >____  )        |
|                         \/     \/     \/         |
|                                                  |
|           -  -  BREAKING NEWS!  -  -             |
|   A software engineering masterpiece released!   |
|  ___________________________                     |
|  | fun thisReallyWorks() { | "Kotlin  literally  |
|  |   50 times {            | becomes    another  |
|  |     println("""         | language",    said  |
|  |                         | some random Kotlin  |
|  |    This would print     | developer.   After  |
|  |                         | many long years of  |
|  |   oooooooo   .oooo.     | careful    coding,  |
|  |  dP"````"P  d8P'`Y8b    | kotlin-times  says  |
|  | d88888b.   888    888   | goodbye to the lab  |
|  |     `Y88b  888    888   | and  finally  sees  |
|  |       ]88  888    888   | the  light of day.  |
|  | o.   .88P  `88b  d88'   | "Pure awesomeness", |
|  | '8bd88P"    `Y8bd8P'    | said the other guy. |
|  |                         |      -  -  -        /
|  |                times!   |   More info and    /
|  |     """)                |    poor quality   /
|  |   }                     |  screen captures /
|  | }                       |    on page 42.  /
|  |_________________________|              /\/
\                                          /
 \  /\   In other news: Java still verbose/
  \/  \/\    /\  /\/\  /\/\  /\/\    /\  /
         \  /  \/    \/    \/    \  /  \/
          \/                      \/
```

[![Maven Central](https://img.shields.io/maven-central/v/com.github.czyzby/kotlin-times.svg)](http://mvnrepository.com/artifact/com.github.czyzby/kotlin-times)
![Just kidding](https://img.shields.io/badge/coverage-101%25-red.svg) [![Kotlin](https://img.shields.io/badge/kotlin-1.0.3-orange.svg)](http://kotlinlang.org/)

You might have thought that Kotlin cannot get any better - but *now* you have found *this* library. Thanks to
`kotlin-times` your Kotlin applications will never be the same. Enter the future of programming.

# Kotlin Times

This library, carefully crafted by our Kotlin experts, extends `Byte`, `Short`, `Int` and `Long` types with `infix`
methods sharing `times` identifier. It effectively allows its users to set up simple and readable loops with a pleasant
Kotlin*-ish* syntax:
```Kotlin
50 times {
  println("Will be printed 50 times!")
}
```

You can access current iteration index as well! It starts at `0` and ends at `n-1`.
```Kotlin
10 times { index ->
  println("This is the $index run.")
}
```

As usual in case of single-parameter lambdas, current iteration index can be also accessed with `it`.
```Kotlin
10 times {
  println("This is the $it run.")
}
```

If you prefer even less verbose operators, `times` happens to be the valid name of the `*` operator, which - combined
with a number - is a pretty readable and obvious way of saying that you want to repeat a loop block for a certain amount
of times. Lucky us.
```Kotlin
10 * {
  println("Equivalent to '10 times {...}'")
}
```

Thanks to the fact that these are all `inline` functions, there is little-to-none runtime overhead for their usage -
they compile to pretty much the same byte code as regular Kotlin loops (or Java ones, for that matter). Needless to say,
these should be as fast as any other simple loop created with the official API. In fact, methods similar to these
obviously *should* be a part of the official API, available out of the box in the standard library. Duh.

## Is it stable?

Definitely. We are proud to announce that **all** of the extension methods are fully tested on every possible number in
each value range. 100% test coverage comes at a price: the full test suite can run for hours due to ~~integers and longs
being big~~ their admirable complexity.

## Why would you even do that?

Joking aside, I kind of missed the good old classic Java `for(int i=0; i<n; i++)` loop. Not sure if such syntax is even
supported by Kotlin, which I found pretty surprising. (You know, `'var' on loop parameter is not allowed`.) Yeah, I'm
probably getting old.

Still, I personally don't find the range syntax more readable than `times` or even `*`, and ranges actually *can* be
slightly error-prone. For example, the innocent looking `for(i in 0..n-1)` might loop `Int.MAX_VALUE` times (instead of
being silently ignored) if `n` happens to be `Int.MIN_VALUE`. Needless to say, `for(i in 1..n)` can be less useful in
the 0-indexed Java world, as you may have to subtract `1` manually from each value. And using a `while` loop is usually
too verbose if you just want to repeat an action `n` times.

This "library" might seem like a joke, but - to be honest - I personally find it a decent alternative to numeric ranges,
which is both easy to read and pretty useful for all kinds of debugging and testing stuff when all you want is to set up
a simple loop as quickly as possible. And I didn't want to ship it with a complete complex utility library. Sue me.

### Equivalents

```Kotlin
var i = 0
while(i < n) {
  // Do something.
  i++
}
```
Too verbose. Next.
```Kotlin
var i = -1
while(++i < n) {
  // Do something.
}
```
Not even trying.

```Kotlin
for(i in 0..n-1) {
  // Do something.
}
```
"Crashes" on `Int.MIN_VALUE` - other than that, this seems to be a sensible way to set it up.

```Kotlin
for(i in 1..n) {
  val index = i - 1
  // Do something.
}
```
Awkward if you need iteration indexes to start with 0.

```Kotlin
for(i in 0 until n) {
  // Do something.
}
```
Verbose. Ish.

```Kotlin
(0..n-1).forEach { i ->
  // Do something.
}

(0 until n).forEach { i ->
  // Do something.
}
```
This might be my personal favorite, but it still seems more verbose than necessary.

```Kotlin
inline operator fun IntRange.invoke(action: (Int) -> Unit) {
  for (i in this) action(i)
}

// Given the operator extension, you can do this:
(0..n-1) { i ->
  // Do something. 
}
```
I pity maintainers of your code if you do this, but I have got to admit it looks unsettlingly tempting.

```Kotlin
repeat(n) { i ->
  // Do something.
}
```
*...Um, wait, is this library actually necessary?*

## How do I include this beauty in my project?

Easily - its already on Maven Central.

### Maven
```XML
<dependency>
  <groupId>com.github.czyzby</groupId>
  <artifactId>kotlin-times</artifactId>
  <version>1.0</version>
</dependency>
```

### Gradle
```Groovy
compile 'com.github.czyzby:kotlin-times:1.0'
```

```Groovy
compile group: 'com.github.czyzby', name: 'kotlin-times', version: '1.0'
```

### Working with the sources

Since this library consists of a [single Kotlin file](src/main/kotlin/kt/times/times.kt), you can just copy the
extension methods to your application and modify them however you like. You can also clone this repository and use
[Gradle](http://gradle.org/) to set up this project, if you really want to.

The code is dedicated to public domain, so feel free to do anything. Just so you know.

#### Variations

If you're feeling brave, try refactoring `times` to something like `x` for this awkwardly short syntax without
overloaded operators: `8 x { println("Will work just fine.") }`. Life is a sandbox.

## The future

Our experts are currently working on extension methods for other numeric types. Hopefully, if the project is not aborted
by then, the official `2.0` version will be released in 2042.

## Contribution

If you do not think that `kotlin-times` is perfect in every way for some reason, you can create an issue or open a pull
request. Thanks in advance.

