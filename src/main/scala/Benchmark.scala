package com.yuvimasory.tostring

import Constants._

object Constants {

  val name = "John Doe"
  val age = 30
}

class CreationBenchmark extends SimpleScalaBenchmark {
  
  def timeCreateCaseClassPerson(reps: Int) = repeat(reps) {
    CasePerson(name, age)
  }
  
  def timeCreateLabeledToStringValPerson(reps: Int) = repeat(reps) {
    ValPerson(name, age)
  }
 
  def timeCreateLabeledToStringLazyValPerson(reps: Int) = repeat(reps) {
    LazyValPerson(name, age)
  }
 
  def timeCreateLabeledToStringDefPerson(reps: Int) = repeat(reps) {
    DefPerson(name, age)
  }  
}

class SubsequentToStringsBenchmark extends SimpleScalaBenchmark {
  
  var casePerson: CasePerson = _
  var valPerson: ValPerson = _
  var defPerson: DefPerson = _
  var lazyPerson: LazyValPerson = _

  var stopJit: Any = ""

  override def setUp() {
    casePerson = CasePerson(name, age)
    casePerson.toString
    valPerson = ValPerson(name, age)
    valPerson.toString
    defPerson = DefPerson(name, age)
    defPerson.toString
    lazyPerson = LazyValPerson(name, age)
    lazyPerson.toString
  }

  def timeSubsequentToStringsOfCaseClassPerson(reps: Int) = repeat(reps) {
    casePerson.toString + casePerson.toString
  }
  
  def timeSubsequentToStringsOfLabeledToStringValPerson(reps: Int) =
    repeat(reps) {
      valPerson.toString + valPerson.toString
  }
 
  def timeSubsequentToStringsOfLabeledToStringLazyValPerson(reps: Int) =
    repeat(reps) {
      lazyPerson.toString + lazyPerson.toString
  }
 
  def timeSubsequentToStringsOfLabeledToStringDefPerson(reps: Int) =
    repeat(reps) {
      defPerson.toString + defPerson.toString
  }  
}

case class ValPerson(name: String, age: Int) extends LabeledToStringVal
case class LazyValPerson(name: String, age: Int) extends LabeledToStringLazyVal
case class DefPerson(name: String, age: Int) extends LabeledToStringDef
case class CasePerson(name: String, age: Int)

