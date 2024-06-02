package mk.ukim.finki.songlibraryapplication.model.exceptions;

public class InvalidSongIdException extends RuntimeException{
    public InvalidSongIdException(Long id){
        super(String.format("No song with Id = %d found", id));
    }
}
