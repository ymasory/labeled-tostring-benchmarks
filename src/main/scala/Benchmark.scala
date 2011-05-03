package com.yuvimasory.tostring

class Benchmark extends SimpleScalaBenchmark {
  
  val name = "John Doe"
  val age = 30
 
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

case class ValPerson(name: String, age: Int) extends LabeledToStringVal
case class LazyValPerson(name: String, age: Int) extends LabeledToStringLazyVal
case class DefPerson(name: String, age: Int) extends LabeledToStringDef
case class CasePerson(name: String, age: Int)
class Person(name: String, age: Int)
