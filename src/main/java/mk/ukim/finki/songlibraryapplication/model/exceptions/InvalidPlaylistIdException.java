package mk.ukim.finki.songlibraryapplication.model.exceptions;

public class InvalidPlaylistIdException extends RuntimeException{
    public InvalidPlaylistIdException(Long id){
        super(String.format("No playlist with Id = %d found", id));
    }
}
