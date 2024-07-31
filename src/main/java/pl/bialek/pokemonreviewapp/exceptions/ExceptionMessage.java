package pl.bialek.pokemonreviewapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
@Value
@Builder
@AllArgsConstructor(staticName = "of")
public class ExceptionMessage {
    String errorId;
    String message;
    Date date;

    public void setMessage(String message) {

    }

    public void setTimestamp(Date date) {

    }
}
