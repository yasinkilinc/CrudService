package tr.com.atez.crud.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseDTO<ID> implements Serializable {
    private ID id;
}
