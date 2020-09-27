package com.gridnine.testing;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
public class FilterFlightImpl implements IFilterFlight {
    @Override
    public List<Flight> departureToTheBeforeCurrentTime(List<Flight> flightList, LocalDateTime dateTime) {
        return flightList
                .stream()
                .filter(flight ->this.isBeforeDepartureDate(flight,dateTime)).collect(Collectors.toList());
    }
    @Override
    public List<Flight> excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flights){
        return flights
                .stream()
                .filter(flight ->this.isArrivalDateBeforeDepartureDate(flight)).collect(Collectors.toList());
    }
    @Override
    public List<Flight> excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flights) {
        return  flights
                .stream()
                .filter(flight ->getFlight(flight,2))
                .collect(Collectors.toList());
    }

    private boolean isBeforeDepartureDate(Flight flight,LocalDateTime dateTime){
        return flight
                .getSegments()
                .stream()
                .filter(x->x.getDepartureDate().isBefore(dateTime))
                .count()>0;
    }
    private boolean isArrivalDateBeforeDepartureDate(Flight flight){
        return flight
                .getSegments()
                .stream()
                .filter(segment->segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                .count()>0;
    }
    private boolean getFlight(Flight flight,int periodTime){
        if(flight.getSegments().size()==1){
            return false;
        }
        List<Segment> segmentList=flight.getSegments();
        int size=segmentList.size()-1;
        int indexSegment=0;
        int nextSegment=0;
        while (indexSegment<size){
            nextSegment=indexSegment+1;
            int data1=segmentList.get(indexSegment).getArrivalDate().getHour();
            int data2=segmentList.get(nextSegment).getDepartureDate().getHour();
            int delta=data2-data1;
            if(delta>2)return true;
            indexSegment++;
        }
        return false;
    }

}
