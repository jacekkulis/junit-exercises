package pl.dmcs;

import java.io.File;

public class DirProcessor {

	private ImageProcessor imageProcessor;

	public DirProcessor(ImageProcessor imageProcessor) {
		this.imageProcessor = imageProcessor;
	}

	void enhanceImage(String directory, String extension) {
		File dir = new File(directory);
		File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));

		for (File file : files) {
			imageProcessor.enhanceImage(file.toString());
		}
	}
}
