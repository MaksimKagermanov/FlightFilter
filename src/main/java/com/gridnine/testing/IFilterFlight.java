package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface IFilterFlight {
    List<Flight> departureToTheBeforeCurrentTime(List<Flight> flightList, LocalDateTime dateTime);
    List<Flight> excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights);
    List<Flight> excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flights);
}
