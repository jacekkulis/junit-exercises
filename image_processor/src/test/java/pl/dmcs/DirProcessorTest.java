package pl.dmcs;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DirProcessorTest {

	private static final String JPG = "jpg";
	private static final String PNG = "png";
	private static final String BMP = "bmp";

	private String TEST_DIR = new File("src/test/java/resources").getAbsolutePath() + "/";

	@Mock
	ImageProcessor imageProcessor = mock(ImageProcessor.class);

	@InjectMocks
	DirProcessor dirProcessor = new DirProcessor(imageProcessor);

	@Test
	void testEnhanceJPGImages() {
		dirProcessor.enhanceImage(TEST_DIR, JPG);

		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "1.jpg");
		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "2.jpg");
		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "3.jpg");

		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "photo1.jpg");
		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "1.png");
		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "2.png");
	}

	@Test
	void testEnhancePNGImages() {
		dirProcessor.enhanceImage(TEST_DIR, PNG);

		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "1.png");
		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "2.png");

		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "1.jpg");
		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "2.jpg");
	}

	@Test
	void testEnhanceBMPImages() {
		dirProcessor.enhanceImage(TEST_DIR, BMP);

		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "1.bmp");
		verify(imageProcessor, times(1)).enhanceImage(TEST_DIR + "2.bmp");

		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "1.jpg");
		verify(imageProcessor, never()).enhanceImage(TEST_DIR + "2.jpg");
	}
}
