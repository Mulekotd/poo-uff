package sistemaboleto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class BoletoWriter implements IBoletoFileStream {
    private final File file;

    private RandomAccessFile raf;

    public BoletoWriter(File file) {
        this.file = file;
    }

    public void write(String content) throws Exception {
        write(content, false);
    }

    public void write(String content, boolean shouldAppend) throws Exception {
        if (!file.isFile() || !file.canWrite()) {
            throw new BoletoException("Não foi possível escrever no arquivo.");
        }

        this.openStream(shouldAppend);

        try {
            long fp = raf.getFilePointer();

            if (fp > 0) {
                raf.seek(fp - 1);

                if (raf.read() != '\n') {
                    raf.write('\n');
                }
            }

            String line = content.endsWith("\n") ? content : content + "\n";

            raf.write(line.getBytes(Charset.defaultCharset()));

            if (!shouldAppend) {
                raf.setLength(raf.getFilePointer());
            }
        } finally {
            this.closeStream();
        }
    }

    private long firstLineEndPointer() throws IOException {
        int character;

        while ((character = raf.read()) != -1 && character != '\n');

        return raf.getFilePointer();
    }

    @Override
    public void openStream() throws IOException {
        this.openStream(false);
    }

    public void openStream(boolean append) throws IOException {
        this.closeStream();

        raf = new RandomAccessFile(file, "rw");
        long fp = append ? raf.length() : firstLineEndPointer();
        raf.seek(fp);
    }

    @Override
    public void closeStream() throws IOException {
        if (raf != null) {
            raf.close();
            raf = null;
        }
    }
}
