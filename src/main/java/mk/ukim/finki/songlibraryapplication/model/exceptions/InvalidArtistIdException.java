package mk.ukim.finki.songlibraryapplication.model.exceptions;

public class InvalidArtistIdException extends RuntimeException{
    public InvalidArtistIdException(Long id){
        super(String.format("No artist with Id = %d found", id));
    }
}
