BrotliHaxeJavaDecode
========================
BrotliHaxeJavaDecode is a pure(in meaning of no platform native lib) java wrapper for decode(decompress) Brotli stream
based on BrotliHaxe[ https://github.com/dominikhlbg/BrotliHaxe  ].

To decompress Brotli, just include the 2 jar files in `dist/` into your java project and call
`BrDecode.decode(new ByteArrayInputStream(bytes), baos=new ByteArrayOutputStream());`

TODO:
you can also implement encode(compress) methods like `BrDecode` did.

