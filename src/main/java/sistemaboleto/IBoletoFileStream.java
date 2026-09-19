package sistemaboleto;

import java.io.IOException;

public interface IBoletoFileStream {
    public void openStream() throws IOException;
    public void closeStream() throws IOException;
}
