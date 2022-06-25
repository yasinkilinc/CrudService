package tr.com.atez.crud.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country extends AbstractBaseEntity {

	@Column(name = "name", length = 100)
	private String name;

	/**
	 * ülke kısa kod
	 */
	@Column(name = "ncts_code", length = 3)
	private String nctsCode;

	@Column(name = "lang", length = 3)
	private String lang;

}
