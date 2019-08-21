@file:DependsOn("io.reactivex.rxjava2:rxkotlin:2.3.0")

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

fun isEven(a: Int) = a % 2 == 0

var subject: Subject<Int> = PublishSubject.create()
subject.map({ isEven(it) }).subscribe({
  println("The number is ${(if (it) "Even" else "Odd")}" )
 })

subject.onNext(4)
subject.onNext(9)

