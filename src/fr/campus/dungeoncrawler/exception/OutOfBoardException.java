package fr.campus.dungeoncrawler.exception;

/**
 * Exception thrown when a character tries to move
 * beyond the final cell of the board.
 */
public class OutOfBoardException extends Exception{
    /**
     * Creates an exception with a detailed message.
     *
     * @param message the message explaining the error
     */
    public OutOfBoardException(String message) {
        super(message);
    }
}
