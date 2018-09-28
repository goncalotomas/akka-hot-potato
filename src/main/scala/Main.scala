import akka.actor.ActorSystem
import akka.actor.ActorRef
import akka.actor.Actor
import akka.actor.Props


object Main {
  def main(args: Array[String]): Unit = {
    // Create the actor system that will spawn our actors
    val actorSystem = ActorSystem("akka4scala");

    // Create the actor that will send out the messages
    val actor1 = actorSystem.actorOf(Props[PotatoThrower], "rick")
    val actor2 = actorSystem.actorOf(Props[PotatoThrower], "morty")
    val actor3 = actorSystem.actorOf(Props[PotatoThrower], "summer")
    val actor4 = actorSystem.actorOf(Props[PotatoThrower], "jerry")
    val actor5 = actorSystem.actorOf(Props[PotatoThrower], "beth")

    println("starting new game...")
    actor1 ! Prepare(actor2)
    actor2 ! Prepare(actor3)
    actor3 ! Prepare(actor4)
    actor4 ! Prepare(actor5)
    actor5 ! Prepare(actor1)

    actor1 ! Start(12)
  }
}
