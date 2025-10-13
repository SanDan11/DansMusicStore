package utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;


public class DatabaseBackup {

    private static final String SOURCE_DB = "data/music_store.db";
    private static final String BACKUP_FOLDER = "backup/";

    public static void createBackup() {

        File sourceFile = new File(SOURCE_DB);
        File backupDir = new File(BACKUP_FOLDER);

        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(new Date());
        File backupFile = new File(backupDir, "Music_store_backup_" + timeStamp + ".db");

        try (FileChannel src = new FileInputStream(sourceFile).getChannel();
            FileChannel dest = new FileOutputStream(backupFile).getChannel()) {

            dest.transferFrom(src, 0, src.size());
            System.out.println("Backup created: " + backupFile.getName());

            File[] backups = backupDir.listFiles((dir, name) -> name.endsWith(".db"));
            if (backups != null && backups.length > 3) {
                Arrays.sort(backups, Comparator.comparing(File::lastModified).reversed());
                for (int i = 3; i < backups.length; i++){
                    if (backups[i].delete()) {
                    System.out.println("Delete old backup: " + backups[i].getName());
                }
            }
        }

    } catch (IOException e) {
        System.out.println("Error creating backup: " + e.getMessage());
        }
    }
}
