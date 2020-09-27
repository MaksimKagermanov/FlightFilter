package com.gridnine.testing;

public class PrintFlight {
    public static void print(Flight flight) {
        System.out.println("----------------------------------");
        flight.getSegments().forEach(segment->{
            System.out.println("Вылет: "+segment.getDepartureDate());
            System.out.println("Прибытие: "+segment.getArrivalDate());
        });
        System.out.println("----------------------------------");
    }
}
