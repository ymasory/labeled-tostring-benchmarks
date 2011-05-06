package com.yuvimasory.tostring

import java.security.Permission

import com.google.caliper.{Benchmark, Runner => CaliperRunner}

object Runner {

  def main(args: Array[String]) {
    val benchmarks = List(classOf[CreationBenchmark],
                          classOf[SubsequentToStringsBenchmark]).reverse
    for (benchmark <- benchmarks) {
      val thread = new BenchmarkThread(benchmark, args)
      thread start()
      thread join()
    }
  }

  class BenchmarkThread(clazz: Class[_ <: Benchmark],
                        args: Array[String]) extends Thread {

    override def run() {
      val securityManager = new SecurityManager() {
        override def checkPermission(permission: Permission) {
          if ("exitVM.0".equals(permission.getName())) {
            throw new SecurityException("Blocking Caliper's System.exit().")
          }
        }
      }
      System setSecurityManager securityManager
      CaliperRunner main (clazz, args: _*)
    }
  }
  
}
