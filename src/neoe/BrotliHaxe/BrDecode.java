package neoe.BrotliHaxe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import decode.streams.BrotliInput;
import decode.streams.BrotliOutput;

public class BrDecode {

	public static boolean DEBUG = false;
	static {
		try {
			decode.Dictionary.kBrotliDictionary = bsToIs(
					FileUtil.read(BrDecode.class.getResourceAsStream("dictionary.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void decode(ByteArrayInputStream bais, ByteArrayOutputStream baos) throws IOException {
		BrotliInput bi = new BrotliInput();
		BrotliOutput bo = new BrotliOutput();
		bi.data_ = bais;
		bi.cb_ = ((haxe.lang.Function) (new haxe.lang.Closure(BrDecode.class, "BrotliInputFunction")));
		bo.data_ = baos;
		bo.cb_ = ((haxe.lang.Function) (new haxe.lang.Closure(BrDecode.class, "BrotliOutputFunction")));
		decode.Decode.BrotliDecompress(bi, bo);
	}

	private static int[] bsToIs(byte[] bs) {
		int len = bs.length;
		int[] is = new int[len];
		for (int i = 0; i < len; i++) {
			is[i] = bs[i] & 0xff;
		}
		return is;
	}

	public static int BrotliInputFunction(ByteArrayInputStream data, int[] buf, int buf_off, int count)
			throws IOException {

		byte[] ib = new byte[count];
		int ilen = data.read(ib);
		if (DEBUG)
			System.out.printf("in %d, buf[%d] off %d count %d\n", ilen, buf.length, buf_off, count);
		for (int i = 0; i < ilen; i++) {
			buf[buf_off + i] = ib[i] & 0xff;
		}
		return ilen;
	}

	public static int BrotliOutputFunction(ByteArrayOutputStream data, int[] buf, int buf_off, int count) {
		if (DEBUG)
			System.out.printf("out,buf[%d] off %d count %d\n", buf.length, buf_off, count);
		for (int i = 0; i < count; i++) {
			data.write(buf[buf_off + i]);
		}
		return count;
	}

}
