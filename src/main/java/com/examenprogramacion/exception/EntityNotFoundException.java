package com.examenprogramacion.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.aspectj.apache.bcel.classfile.Code;


@Data
// Crea los metodos equals y hashCode .
//En este caso, se esta configurando para considerar tambien los campos de la superclase osea de la ApiException

@EqualsAndHashCode (callSuper = true)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
