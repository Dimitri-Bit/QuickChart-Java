package me.dimitri.exception;

public class InvalidChartException extends Exception {

    public InvalidChartException(String message) {
        super(message);
    }

    public InvalidChartException() {
        super("Invalid chart type object provided");
    }

}
