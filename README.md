BrotliHaxeJavaDecode
========================
BrotliHaxeJavaDecode is a pure(in meaning of no platform native lib) java library wrapper for decode(decompress) Brotli stream
based on BrotliHaxe[ https://github.com/dominikhlbg/BrotliHaxe  ].

To decompress Brotli, just include the 2 jar in `dist/` and call
`BrDecode.decode(new ByteArrayInputStream(bytes), baos=new ByteArrayOutputStream());`

TODO:
you also implement encode[compress] methods like `BrDecode`

