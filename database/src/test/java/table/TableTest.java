package table;

import ghostface.dev.impl.column.ColumnsImpl;
import ghostface.dev.impl.column.StringColumn;
import ghostface.dev.impl.data.DataUUID;
import ghostface.dev.mapping.column.Column;
import ghostface.dev.mapping.data.Data;
import ghostface.dev.mapping.key.Key;
import ghostface.dev.mapping.key.UUIDKey;
import ghostface.dev.mapping.table.Table;
import ghostface.dev.mapping.table.UUIDTable;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public final class TableTest {

    private final @NotNull Column<String> name = new StringColumn("name");
    private final @NotNull Column<String> email = new StringColumn("email");

    @Test
    public void test() {
        final @NotNull Table<Key<UUID>> table = new UUIDTable(new ColumnsImpl(name, email));

        Assertions.assertTrue(table.getKeys().isEmpty());
        Assertions.assertTrue(table.getAll().isEmpty());

        Assertions.assertFalse(table.getColumns().add(name));
        Assertions.assertFalse(table.getColumns().isEmpty());

        final @NotNull Data<Key<UUID>> data = new DataUUID(UUIDKey.create(), table);
        table.create(data);

        Assertions.assertTrue(data.contains(name));
        Assertions.assertTrue(table.contains(data.getKey()));
        Assertions.assertTrue(table.contains(data));

        Assertions.assertEquals(table.get(data.getKey()).get(), data);
        System.out.println(table.serialize());
    }
}