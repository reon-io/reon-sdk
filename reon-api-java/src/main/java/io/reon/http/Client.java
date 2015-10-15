package io.reon.http;

import java.io.Closeable;
import java.io.IOException;

public class Client implements Closeable {
	private final Connection conn;
	private final MessageWriter writer;
	private final ResponseReader reader;

	public Client(Connection conn) throws IOException {
		this.conn = conn;
		writer = new MessageWriter(conn.getOutputStream());
		reader = new ResponseReader(conn.getInputStream());
	}

	public Response send(Request request) throws IOException {
		writer.write(request);
		return reader.read();
	}

	@Override
	public void close() throws IOException {
		conn.close();
	}
}
