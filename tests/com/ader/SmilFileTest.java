package com.ader;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.ader.smil.TextElement;

import junit.framework.TestCase;

public class SmilFileTest extends TestCase {

    public void testParsingTextOnlyFile() throws Exception {
        SmilFile smilFile = new SmilFile();
        smilFile.open("Resources/WIPO-Treaty-D202Fileset/d202_1.smil");
        assertTrue(smilFile.getTextSegments().size() > 0);
        TextElement textElement = smilFile.getTextSegments().get(0);
        assertEquals("WIPOTreatyForVisuallyImpaired.html#id_4", textElement.getSrc());
    }
    
    public void testParsingAudioOnlyFile() throws Exception {
        SmilFile smilFile = new SmilFile();
        smilFile.open("Resources/light-man/icth0001.smil");
        assertTrue(smilFile.getAudioSegments().size() > 0);
        assertEquals(smilFile.getAudioSegments().get(0).getClipBegin(), 0.0);
        assertEquals(smilFile.getAudioSegments().get(1).getClipBegin(), 1.384);
    }
}