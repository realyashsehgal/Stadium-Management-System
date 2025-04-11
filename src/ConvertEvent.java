package src;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConvertEvent {
    int id;
    private String name;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private int seats;

    public ConvertEvent(int id, String name, LocalDate date, LocalTime start, LocalTime end, int seats) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.start = start;
        this.end = end;
        this.seats = seats;
    }

    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public int getSeats() {
        return seats;
    }
}
