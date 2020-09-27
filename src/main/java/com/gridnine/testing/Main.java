package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        FilteredDataPrint dataFiltering = new FilteredDataPrintImpl();
        dataFiltering.printFlightList(FlightBuilder.createFlights());
        dataFiltering.departureToTheCurrentTime(FlightBuilder.createFlights());
        dataFiltering.excludeSegmentsWithArrivalDateEarlierThanDepartureDate(FlightBuilder.createFlights());
        dataFiltering.excludeTotalTimeSpentOnEarthExceedTwoHours(FlightBuilder.createFlights());
    }
}
