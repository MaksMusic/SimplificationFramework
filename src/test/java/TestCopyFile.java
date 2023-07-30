
import files.FilesImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCopyFile {
    public static void main(String[] args) throws IOException {
        FilesImpl.copyFile(Paths.get("C:\\Users\\Admin\\IdeaProjects\\SimplificationFramework\\src\\main\\java\\files\\h1"),
            Paths.get("C:\\Users\\Admin\\IdeaProjects\\SimplificationFramework\\src\\main\\java\\files\\h2"));

    }
}
