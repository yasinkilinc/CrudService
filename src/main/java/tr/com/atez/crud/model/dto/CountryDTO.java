package tr.com.atez.crud.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CountryDTO extends BaseDTO<UUID> {


	private String name;

	private String nctsCode;

	private String lang;


}
