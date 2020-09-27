import com.gridnine.testing.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.gridnine.testing.Segment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IFilterFlightImplTest {
    IFilterFlight filterFlight=new FilterFlightImpl();
    LocalDateTime dateTime=LocalDateTime.now();
    List<Flight> flightList=new ArrayList<>();
    /////////////////////////////////////////////////////
    List<Segment> segmentListForBefore=new ArrayList<>();
    List<Segment> segmentListTwoHours=new ArrayList<>();
    List<Segment> segmentListDeltaMinus=new ArrayList<>();
    ////////////////////////////////////////////////////
    Segment segment=new Segment(dateTime.minusHours(1),dateTime.plusHours(2));
    Segment segment1=new Segment(dateTime.plusHours(5),dateTime.plusHours(8));
    Segment segment2=new Segment(dateTime.plusHours(1),dateTime.minusHours(4));
    ////////////////////////////////////////////////////////////////////////////
    Flight flightBefore;
    Flight flightMinus;
    Flight flightDeltaTwoHours;
    @BeforeEach
    void init(){
        segmentListForBefore.add(segment);
        segmentListDeltaMinus.add(segment2);
        segmentListTwoHours.add(segment);
        segmentListTwoHours.add(segment1);
        flightBefore=new Flight(segmentListForBefore);
        flightMinus=new Flight(segmentListDeltaMinus);
        flightDeltaTwoHours=new Flight(segmentListTwoHours);
        flightList.add(flightBefore);
        flightList.add(flightMinus);
        flightList.add(flightDeltaTwoHours);
    }

    @Test
    void departureToTheCurrentTimeTest(){
        List<Flight> listTest=new ArrayList<>();
        listTest.add(flightBefore);
        Assertions.assertTrue(listTest.containsAll(filterFlight.departureToTheBeforeCurrentTime(flightList,dateTime)));
    }
    @Test
    void excludeSegmentsWithArrivalDateEarlierThanDepartureDateTest(){
        List<Flight> listTest=new ArrayList<>();
        listTest.add(flightMinus);
        Assertions.assertTrue(listTest.containsAll(filterFlight.excludeSegmentsWithArrivalDateEarlierThanDepartureDate(flightList)));
    }
    @Test
    void excludeTotalTimeSpentOnEarthExceedTwoHoursTest(){
        List<Flight> listTest=new ArrayList<>();
        listTest.add(flightDeltaTwoHours);
        Assertions.assertTrue(listTest.containsAll(filterFlight.excludeTotalTimeSpentOnEarthExceedTwoHours(flightList)));
    }
}
