package src;

import java.time.LocalDate;

public class ConvertEvent {
    private String name;
    private LocalDate date;
    private LocalDate start;
    private LocalDate end;
    private int seats;

    public ConvertEvent(String name, LocalDate date, LocalDate start, LocalDate end, int seats) {
        this.name = name;
        this.date = date;
        this.start = start;
        this.end = end;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public int getSeats() {
        return seats;
    }
}
