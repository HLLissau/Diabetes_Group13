package group13.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "Treats")
@IdClass(TreatsId.class)
public class Treats {
	@Id
	@Column
	private Long userId;
	@Id
	@Column
	private Long doctorId;
	private void test() {
		

	}
}
