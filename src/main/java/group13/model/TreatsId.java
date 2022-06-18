
package group13.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class TreatsId implements Serializable {

    private Long userId;
    private Long doctorId;

    public TreatsId() {
    }

    public TreatsId(Long UId, Long doctorId) {
        this.userId = UId;
        this.doctorId = doctorId;
    }

}
