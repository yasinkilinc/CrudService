package tr.com.atez.crud.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
@Where(clause = "is_deleted = false")
public abstract class AbstractBaseEntity implements Serializable {

	@Id
	@GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
	@GeneratedValue(generator = "UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "create_date")
	@CreationTimestamp
	private LocalDateTime createDate;

	// @Column(name = "create_user", length = 50)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "create_user_id", foreignKey = @ForeignKey(name = "fk_nctscreate_user_id"))
	@CreatedBy
	private User createUser;

	@Column(name = "update_date")
	@UpdateTimestamp
	private LocalDateTime updateDate;

	// @Column(name = "update_user", length = 50)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "update_user_id", foreignKey = @ForeignKey(name = "fk_nctsupdate_user_id"))
	@LastModifiedBy
	private User updateUser;

	@Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
	private boolean isDeleted;

	@PrePersist
	public void setCreateDate() {
		this.createDate = LocalDateTime.now();
	}

	@PreUpdate
	public void setUpdateDate() {
		this.updateDate = LocalDateTime.now();
	}

}
