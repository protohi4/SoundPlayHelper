package pavel_pratasavitski.soundplayhelper.db;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Item {
    @Id
    public long id;
}
