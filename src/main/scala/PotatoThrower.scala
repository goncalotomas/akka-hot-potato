import akka.actor.Actor
import akka.actor.ActorRef

class PotatoThrower extends Actor {
  var next: ActorRef = null

  def receive = {
    case Prepare(nextTarget) =>
        next = nextTarget
    case Start(number) =>
        println("Counting down from " + number + "... " + self.path.name + " throws first!")
        Thread.sleep(500)
        next ! Catch(number)
    case Catch(number) =>
        if(number == 0) {
            println(self.path.name + " caught the potato and it exploded.")
            println(self.path.name + " loses :(")
            println("game over")
        }
        else {
            println(self.path.name + " caught the potato! \tStill " + (number-1) + " throws left.")
            Thread.sleep(2000)
            next ! Catch(number-1)
        }
  }
}
