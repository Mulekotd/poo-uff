package proxy;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadLocalRandom;

public class File {
    private static final int MIN_WORDS = 1;      // mínimo de 1 valor (2 bytes)
    private static final int MAX_WORDS = 2013;   // máximo de 4026 bytes

    private final String name;
    private final byte[] content;
    private final int length;

    public File() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int words = random.nextInt(MIN_WORDS, MAX_WORDS + 1);

        this.content = new byte[words * 2];
        this.fill(this.content);
        this.length = this.content.length;
        this.name = Integer.toHexString(this.hashCode()) + ".bin";
    }

    private void fill(byte[] bytes) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ByteBuffer buffer = ByteBuffer.wrap(bytes);

        while (buffer.remaining() >= 2) {
            int value = random.nextInt(0x0000, 0x10000); // 0x0000 até 0xFFFF
            buffer.putShort((short) value);
        }
    }

    // Getters

    public String getName() { return this.name; }
    public int getLength() { return this.length; }
    public byte[] getContent() { return this.content.clone(); }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(name + " [length=" + length + "] ");
        ByteBuffer buffer = ByteBuffer.wrap(content);

        while (buffer.remaining() >= 2) {
            builder.append(String.format("%04X ", buffer.getShort() & 0xFFFF));
        }

        return builder.toString().trim();
    }
}
