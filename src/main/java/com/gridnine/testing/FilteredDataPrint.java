package com.gridnine.testing;
import java.util.List;
public interface FilteredDataPrint {
    void printFlightList(List<Flight> flightList);
    void departureToTheCurrentTime(List<Flight> flights);
    void excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights);
    void excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flights);
}
