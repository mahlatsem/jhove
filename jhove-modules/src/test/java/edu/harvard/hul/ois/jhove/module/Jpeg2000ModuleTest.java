package edu.harvard.hul.ois.jhove.module;


import edu.harvard.hul.ois.jhove.JhoveBase;
import edu.harvard.hul.ois.jhove.JhoveException;
import edu.harvard.hul.ois.jhove.RepInfo;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Jpeg2000ModuleTest {

    @Test
    public void originalImageCheck_jp2() throws IOException, JhoveException {
        String filePath = this.getClass().getResource("/RoskildeFjord3.jp2").getFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"r");
        RepInfo repInfo = new RepInfo(filePath);

        Jpeg2000Module jpeg2000Module = new Jpeg2000Module();
        jpeg2000Module.setBase(new JhoveBase());
        jpeg2000Module.parse(randomAccessFile,repInfo);

        assertTrue((repInfo.getValid() == 1));
    }


    @Test
    public void originalImageCheck_jpx() throws IOException, JhoveException {
        String filePath = this.getClass().getResource("/ROITest.jpx").getFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"r");
        RepInfo repInfo = new RepInfo(filePath);
        Jpeg2000Module jpeg2000Module = new Jpeg2000Module();

        jpeg2000Module.setBase(new JhoveBase());
        jpeg2000Module.parse(randomAccessFile,repInfo);

        assertTrue((repInfo.getValid() == 1));
    }

    @Test
    public void originalImageCheckShouldFailForNonJpeg2000() throws IOException, JhoveException {
        String filePath = this.getClass().getResource("/id-01.jpg").getFile();
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"r");
        RepInfo repInfo = new RepInfo(filePath);
        Jpeg2000Module jpeg2000Module = new Jpeg2000Module();

        jpeg2000Module.setBase(new JhoveBase());
        jpeg2000Module.parse(randomAccessFile,repInfo);

        assertFalse((repInfo.getValid() == 1));
    }
}