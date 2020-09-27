package com.gridnine.testing;
import java.time.LocalDateTime;
import java.util.List;

public class FilteredDataPrintImpl implements FilteredDataPrint {
    private IFilterFlight filterFlight;
    public FilteredDataPrintImpl()
    {
        this.filterFlight =new FilterFlightImpl();
    }
    public void printFlightList(List<Flight> flightList){
        System.out.println("Количество рейсов "+flightList.size());
        flightList.forEach(PrintFlight::print);
    }
    @Override
    public void departureToTheCurrentTime(List<Flight> flightList)
    {
        System.out.println("====================================");
        System.out.println("Авиарейсы до текущего момента времени");
        this.printFlightList(filterFlight.departureToTheBeforeCurrentTime(flightList,LocalDateTime.now()));
        System.out.println("====================================");
    }
    //Авиаресы где сегменты с датой прилёта раньше даты вылета
    @Override
    public void excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flightList) {
        System.out.println("====================================");
        System.out.println("Авиаресы где сегменты с датой прилёта раньше даты вылета");
        this.printFlightList(filterFlight.excludeSegmentsWithArrivalDateEarlierThanDepartureDate(flightList));
        System.out.println("====================================");
    }
    @Override
    public void excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flightList) {
        System.out.println("====================================");
        System.out.println("Авиарейсы- общее время, проведённое на земле превышает два часа");
        printFlightList(filterFlight.excludeTotalTimeSpentOnEarthExceedTwoHours(flightList));
        System.out.println("====================================");
    }
}
