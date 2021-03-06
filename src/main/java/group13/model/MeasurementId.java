
package group13.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class MeasurementId implements Serializable {

    private Long userId;
    private Timestamp time;

    public MeasurementId() {
    }

    public MeasurementId(Long UId, Timestamp time) {
        this.userId = UId;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasurementId measurementId = (MeasurementId) o;
        return this.userId == measurementId.userId &&
                time.equals(measurementId.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, time);
    }
}
