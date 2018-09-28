import akka.actor.ActorRef

case class Prepare(next: ActorRef)
case class Start(number: Int)
case class Catch(number: Int)
