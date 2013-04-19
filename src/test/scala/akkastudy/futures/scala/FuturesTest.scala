package akkastudy.futures.scala

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import concurrent.ExecutionContext
import java.util.concurrent.Executors
import akka.{util, actor}
import actor.{Props, ActorSystem}
import scala.concurrent.Future
import akka.util.Timeout
import scala.concurrent.duration._
import concurrent.Await
import akkastudy.SenderActor

class FuturesTest extends FlatSpec with MustMatchers {
  behavior of "An Actor System should"

//  it should "A future is a object that has an answer but not quite yet delivered" in {
//    //An execution context is required
//    implicit val executionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(12))
//
//    val future = Future {
//      "Hello" + " " + "World"
//    }
//
//    implicit val timeout = Timeout(5 seconds)
//    println("Step 1")
//    val result = Await.result(future, timeout.duration) //blocking
//    println("Step 2: " + result)
//
//    result must equal("Hello World")
//  }
//
//  it should "A future is a object that has an answer but not quite yet delivered, and can be read non-blocking" in {
//    //An execution context is required
//    implicit val executionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(12))
//
//    val future = Future {
//      "Hello" + " " + "World"
//    }
//
//    future foreach (x => println("I got an answer" + x)) //asynchonous
//    println("running1")
//    println("running2")
//    println("running3")
//
//  }

//  it should "be able to ask information of an Actor, where as the the Actor will return the answer, blocked" in {
//    import akka.pattern.ask
//    import system.dispatcher
//
//    implicit val timeout = util.Timeout(1 seconds)
//
//    val system = ActorSystem("MySystem")
//    val futureActor = system.actorOf(Props[FuturesActor], "futuresActor")
//    val promise = (futureActor ? "What is the meaning of love?")
//    val result = Await.result(promise, timeout.duration) //Blocking
//    println(result)
//    Thread.sleep(10000)
//  }

  it should "be able to ask information of an Actor, where as the the Actor will return the answer, non blocked" in {
      import akka.pattern.ask
      import system.dispatcher

      implicit val timeout = util.Timeout(10 seconds)

      val system = ActorSystem("MySystem")
      val futureActor = system.actorOf(Props[FuturesActor], "futuresActor")
      val promise = (futureActor ? "What is the meaning of love?")
      promise foreach println
      Thread.sleep(5000)
  }
}