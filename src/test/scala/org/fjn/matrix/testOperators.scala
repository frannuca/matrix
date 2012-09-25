package org.fjn.matrix

/**
 * Created with IntelliJ IDEA.
 * User: fran
 * Date: 9/25/12
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
object testOperators {

  def main(args:Array[String]){
    val m1  = new Matrix[Double](3,2,false)
    val m2 = new Matrix[Double](2,3,false)


    m1.random
    m2.random

    val r = m1 * m2

    val m1b= new Jama.Matrix(m1.numberRows,m1.numberCols)
    val m2b= new Jama.Matrix(m2.numberRows,m2.numberCols)

    for (i <- 0 until m1.numberRows;
         j <- 0 until m1.numberCols){
      m1b.set(i,j,m1(i,j))
    }

    for (i <- 0 until m2.numberRows;
         j <- 0 until m2.numberCols){
      m2b.set(i,j,m2(i,j))
    }

    val rb = m1b.times(m2b)

    for (i <- 0 until r.numberRows;
         j <- 0 until r.numberCols){
      if(math.abs(r(i,j)-rb.get(i,j))>1e-6){
        throw new Exception("matrix are different")
      }
    }





  }

}
