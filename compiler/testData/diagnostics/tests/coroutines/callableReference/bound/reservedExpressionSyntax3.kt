// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_VARIABLE
package test

object Wrong
object Right

class a {
    class b<T> {
        class c {
            suspend fun foo() = Wrong
        }
    }
}

suspend fun Int.foo() = Right

class Test {
    val a: List<Int> = null!!

    val <T> List<T>.b: Int get() = 42

    val Int.c: Int get() = 42

    val test1: () -> Right = <!RESERVED_SYNTAX_IN_CALLABLE_REFERENCE_LHS!><!DEBUG_INFO_MISSING_UNRESOLVED!>a<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>b<!><<!DEBUG_INFO_MISSING_UNRESOLVED!>Int<!>>.<!DEBUG_INFO_MISSING_UNRESOLVED!>c<!><!>::<!DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>
    val test1a: suspend () -> Right = a.<!NI;DEBUG_INFO_LEAKING_THIS!>b<!>.<!NI;DEBUG_INFO_LEAKING_THIS!>c<!>::foo

    val test2: () -> Right = <!RESERVED_SYNTAX_IN_CALLABLE_REFERENCE_LHS!><!DEBUG_INFO_MISSING_UNRESOLVED!>a<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>b<!><<!DEBUG_INFO_MISSING_UNRESOLVED!>Int<!>>.<!DEBUG_INFO_MISSING_UNRESOLVED!>c<!><!>?::<!DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>
}