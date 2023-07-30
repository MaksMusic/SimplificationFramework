package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

final class FilesCopy {


    public static Path copyFile(Path source, Path destination,StandardCopyOption standardCopyOption) throws IOException {

        class FileVisitorCopy extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path newDestination = destination.resolve(source.relativize(file));
                Files.copy(file,newDestination, standardCopyOption);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Path newDestination = destination.resolve(source.relativize(dir));
                Files.copy(dir,newDestination, standardCopyOption);
                return FileVisitResult.CONTINUE;
            }
        }


        return Files.walkFileTree(source,new FileVisitorCopy());
    }



    public static Path copyFile(Path source, Path destination) throws IOException {

        class FileVisitorCopy extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path newDestination = destination.resolve(source.relativize(file));
                Files.copy(file,newDestination, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path newDestination = destination.resolve(source.relativize(dir));
                Files.copy(dir,newDestination, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        }


        return Files.walkFileTree(source,new FileVisitorCopy());
    }
}
