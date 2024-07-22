package me.dimitri.exception;

public class InvalidChartException extends RuntimeException {

    public InvalidChartException(String message) {
        super(message);
    }

    public InvalidChartException() {
        super("Invalid chart type object provided");
    }

}
