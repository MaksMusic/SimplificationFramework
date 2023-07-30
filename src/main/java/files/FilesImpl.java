package files;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class FilesImpl{

    public static Path copyFile(Path source, Path destination) throws IOException {
       return FilesCopy.copyFile(source,destination);
    }


    public Path copyFile(Path source, Path destination, StandardCopyOption standardCopyOption) throws IOException {
        return FilesCopy.copyFile(source,destination,standardCopyOption);
    }
}
