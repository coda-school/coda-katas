import java.time.LocalTime

object TimeUtility {
  def timeOfDay(clock: Clock) : String = {
    clock.time() match {
      case night if night.getHour >= 0 && night.getHour < 6 => "Night"
      case morning if morning.getHour >= 6 && morning.getHour < 12 => "Morning"
      case afternoon if afternoon.getHour >= 12 && afternoon.getHour < 18 => "Afternoon"
      case _ => "Evening"
    }
  }
}

trait Clock {
  def time(): LocalTime = LocalTime.now()
}
