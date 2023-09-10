package com.dec.Gzip.controller;

import com.dec.Gzip.dto.GZipDTO;
import com.dec.Gzip.service.GZipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class GZipController {
    private GZipService service;

    public GZipController(GZipService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<String> decompress(@RequestBody GZipDTO gZip) throws IOException {
        return ResponseEntity.ok(service.decompress(gZip.code()));
    }
}