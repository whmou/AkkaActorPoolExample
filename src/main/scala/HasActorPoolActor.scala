import akka.actor.{Actor, Props}

import scala.concurrent.ExecutionContext

class HasActorPoolActor extends Actor {

//  implicit val executionContext: ExecutionContext = context.system.dispatchers.lookup("my-dispatcher")
  def receive = {
    case "hello" =>
      val threadId = Thread.currentThread.getId
//      println(context.dispatcher.toString)
      println(s"thread $threadId coming in, start using sleep to demo blocking")
      Thread.sleep(3000)
      println(s"thread $threadId woke up")
    case _       => println("huh?")
  }
}
