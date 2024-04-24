package mx.edu.utez.extra.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomResponse<T> {

    T data;
    Boolean error;
    int StatusCode;
    String message;

    public boolean isError() {
        return error;
    }
}
