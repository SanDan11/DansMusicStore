package utils;


import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseBackup {

    private static final String DB_NAME = "Music_store.db";
    private static final String BACKUP_DIR = "backup";

    public static void createBackup() {
        try{
            Files.createDirectories(Paths.get(BACKUP_DIR));

            String timestamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(new Date());
            String backupName = "music_Store_backup_ " + timestamp + " .db";

            Path source = Paths.get(DB_NAME);
            Path target = Paths.get(BACKUP_DIR, backupName);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Backup created successfully at: " + target.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }
}
