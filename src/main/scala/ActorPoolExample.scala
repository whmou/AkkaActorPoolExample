import java.io.File

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.routing.{FromConfig, RoundRobinPool}
import com.typesafe.config.ConfigFactory

object ActorPoolExample extends App {

  val config = ConfigFactory.load()
  val system = ActorSystem("HelloActorPoolExampleSystem", config)
//  System.out.println(system.settings)
  // default Actor constructor
//  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
//  helloActor ! "hello"
//  helloActor ! "buenos dias"


  val hasActorPoolActors = system.actorOf(Props[HasActorPoolActor].withDispatcher("my-dispatcher").withRouter(RoundRobinPool(2)), "router1")
//  val hasActorPoolActors2 = system.actorOf(Props[HasActorPoolActor].withDispatcher("my-dispatcher"), "router2")
  1 to 10 foreach { _ =>
    hasActorPoolActors ! "hello"
  }

}