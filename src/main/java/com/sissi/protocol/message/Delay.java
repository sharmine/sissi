package com.sissi.protocol.message;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author kim 2013-11-22
 */
@XmlRootElement
public class Delay {

	private final static String XMLNS = "urn:xmpp:delay";

	private String hit;
	
	private String from;

	private String stamp;

	public Delay() {
		super();
	}

	public Delay(String hit, String from, String stamp) {
		super();
		this.hit = hit;
		this.from = from;
		this.stamp = stamp;
	}
	
	@XmlValue
	public String getHit() {
		return hit;
	}

	@XmlAttribute
	public String getXmlns() {
		return XMLNS;
	}

	@XmlAttribute
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@XmlAttribute
	public String getStamp() {
		return stamp;
	}

	public void setStamp(String stamp) {
		this.stamp = stamp;
	}
}
