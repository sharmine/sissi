package com.sissi.protocol.presence;

import com.sissi.protocol.Protocol;

/**
 * @author kim 2013-11-2
 */
public class Show extends Protocol {

	public String text;
	
	public Show() {
		super();
	}
	
	public Show(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
