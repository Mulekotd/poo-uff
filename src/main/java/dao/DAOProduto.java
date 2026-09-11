package dao;

import java.util.ArrayList;
import java.util.Arrays;

import java.nio.ByteBuffer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import sistemapagamento.Produto;

public class DAOProduto {
    private static final int TAM_ATR_ID = Integer.BYTES;
    private static final int TAM_ATR_PRECO = Double.BYTES;
    private static final int TAM_ATR_NOME = 40;
    private static final int TAM_REG = TAM_ATR_ID + TAM_ATR_PRECO + TAM_ATR_NOME;

    private File file;
    private FileInputStream fis;
    private FileOutputStream fos;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean append;

    public DAOProduto(String filepath, boolean append) {
        this.file = new File(filepath);
        this.append = append;

        this.fos = null;
        this.fis = null;
        this.dis = null;
        this.dos = null;
    }

    private void _salvar(Produto produto) throws IOException {
        byte[] bytes = new byte[TAM_ATR_NOME];
        Arrays.fill(bytes, (byte) 0);

        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.put(produto.getNome().getBytes());

        this.dos.writeInt(produto.getCodigo());
        this.dos.writeDouble(produto.getPreco());
        this.dos.write(bytes, 0, TAM_ATR_NOME);
    }

    private Produto _ler() throws IOException {
        int codigo = this.dis.readInt();
        double preco = this.dis.readDouble();

        byte[] bytes = new byte[TAM_ATR_NOME];
        this.dis.readFully(bytes, 0, TAM_ATR_NOME);
        String nome = new String(bytes).trim();

        return new Produto(codigo, preco, nome);
    }

    public void salvar(ArrayList<Produto> produtos) {
        try {
            this.fos = new FileOutputStream(this.file, this.append);
            this.dos = new DataOutputStream(fos);

            for (Produto produto : produtos) {
                this._salvar(produto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            this.fechar();
        }
    }

    public ArrayList<Produto> ler() {
        ArrayList<Produto> produtos = null;

        try {
            this.fis = new FileInputStream(this.file);
            this.dis = new DataInputStream(this.fis);

            int records = (int) this.file.length() / TAM_REG;

            produtos = new ArrayList<>();

            for (int i = 0; i < records; i++) {
                Produto produto = this._ler();
                produtos.add(produto);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            this.fechar();
        }

        return produtos;
    }

    private void fechar() {
        try {
            if (this.fis != null) this.fis.close();
            if (this.fos != null) this.fos.close();
            if (this.dis != null) this.dis.close();
            if (this.dos != null) this.dos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
