package com.javaquasar.java.core.chapter_16_IO_Stream.work_with_buffer_of_cp;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class TextTransfer implements ClipboardOwner {

	public static void main(String[] args) throws UnsupportedFlavorException, IOException {
		TextTransfer textTransfer = new TextTransfer();
		
		
		textTransfer.setClipboard("привет из java");
		System.out.println(textTransfer.getClipboard());

	}

	// This method writes a string to the system clipboard.
	// otherwise it returns null.
	public void setClipboard(String str) {
		StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	public String getClipboard() throws UnsupportedFlavorException, IOException {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub 
		
	}

}
