using System;
using FluentAssertions;
using Moq;
using Xunit;

namespace UnitTestsIntro.Tests
{
    public class TimeUtilityShould
    {
        [Theory]
        [InlineData(0, "Night")]
        [InlineData(4, "Night")]
        [InlineData(6, "Morning")]
        [InlineData(9, "Morning")]
        [InlineData(12, "Afternoon")]
        [InlineData(17, "Afternoon")]
        [InlineData(18, "Evening")]
        [InlineData(23, "Evening")]
        public void GetADescriptionAtAnyTime(int hour, string expectedDescription)
        {
            var clockMock = new Mock<IClock>();
            clockMock.Setup(c => c.Now())
                .Returns(hour.ToDateTime());
            
            new TimeUtility(clockMock.Object)
                .GetTimeOfDay()
                .Should()
                .Be(expectedDescription);
        }
        
        [Fact]
        public void ReturnMorningFor6AM()
        {
            var clockMock = new Mock<IClock>();
            clockMock.Setup(c => c.Now())
                .Returns(new DateTime(2022, 12, 1, 6, 5, 0, 0));
            
            new TimeUtility(clockMock.Object)
                .GetTimeOfDay()
                .Should()
                .Be("Morning");
        }
    }

    internal static class TestExtensions
    {
        public static DateTime ToDateTime(this int hour) 
            => new(2022, 12, 1, hour, 0, 0, 0);
    }
}