package unit.tests.intro;

public class TimeUtility {
    private final Clock clock;

    public TimeUtility(Clock clock) {
        this.clock = clock;
    }

    public String getTimeOfDay() {
        var time = clock.now();

        if (time.getHour() < 6) {
            return "Night";
        } else if (time.getHour() < 12) {
            return "Morning";
        } else if (time.getHour() < 18) {
            return "Afternoon";
        }
        return "Evening";
    }
}