package android.content.res;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetManager {

	public InputStream open(String name) throws IOException {
		return new FileInputStream(name);
	}
}
