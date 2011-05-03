package com.yuvimasory.tostring

class Benchmark extends SimpleScalaBenchmark {
  
  val name = "John Doe"
  val age = 30
 
  def timeCreateCaseClassPerson(reps: Int) = repeat(reps) {
    new CasePerson(name, age) toString
  }
  
  def timeCreateLabeledToStringValPerson(reps: Int) = repeat(reps) {
    new ValPerson(name, age) toString
  }
 
  def timeCreateLabeledToStringLazyValPerson(reps: Int) = repeat(reps) {
    new LazyValPerson(name, age) toString
  }
 
  def timeCreateLabeledToStringDefPerson(reps: Int) = repeat(reps) {
    new DefPerson(name, age) toString
  }  
  
}

case class ValPerson(name: String, age: Int) extends LabeledToStringVal
case class LazyValPerson(name: String, age: Int) extends LabeledToStringLazyVal
case class DefPerson(name: String, age: Int) extends LabeledToStringDef
case class CasePerson(name: String, age: Int)
class Person(name: String, age: Int)
