package test

actual class C actual constructor(n: Int, b: Boolean) {
    constructor(s: String): this(1, false)
}

fun test() {
    C("1")
    C(1, false)
}