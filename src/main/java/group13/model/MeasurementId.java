package group13.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class MeasurementId implements Serializable {

    private int user_Id;
    private Timestamp time;

    public MeasurementId() {
    }

    public MeasurementId(int UId, Timestamp time) {
        this.user_Id = UId;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasurementId measurementId = (MeasurementId) o;
        return this.user_Id == measurementId.user_Id &&
                time.equals(measurementId.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_Id, time);
    }
}
