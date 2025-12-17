namespace UnitTestsIntro
{
    public class TimeUtility
    {
        private readonly IClock _clock;

        public TimeUtility(IClock clock) => _clock = clock;

        public string GetTimeOfDay()
        {
            return _clock.Now().Hour switch
            {
                >= 0 and < 6 => "Night",
                >= 6 and < 12 => "Morning",
                >= 12 and < 18 => "Afternoon",
                _ => "Evening"
            };
        }
    }
}