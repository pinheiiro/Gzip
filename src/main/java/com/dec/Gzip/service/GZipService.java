package com.dec.Gzip.service;

import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

@Service
public class GZipService {
    public String decompress(String gzip) throws IOException {
        byte[] bytesDecodificados = Base64.getDecoder().decode(gzip);

        // Criar um stream para a descompressão GZip
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytesDecodificados);
        GZIPInputStream gzipStream = new GZIPInputStream(byteStream);

        // Ler os dados descomprimidos
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = gzipStream.read(buffer)) != -1) {
            outputBuffer.write(buffer, 0, bytesRead);
        }

        // Converter os dados descomprimidos em uma string UTF-8 (ou outra codificação, se aplicável)

        return outputBuffer.toString("UTF-8");
    }
}
