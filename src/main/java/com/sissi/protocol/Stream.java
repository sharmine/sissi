package com.sissi.protocol;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.sissi.protocol.iq.login.Auth;
import com.sissi.protocol.iq.login.Bind;
import com.sissi.protocol.iq.login.Mechanisms;
import com.sissi.protocol.iq.login.Session;
import com.sissi.write.WriteWithOutClose;

/**
 * @author Kim.shen 2013-10-16
 */
@XmlRootElement(namespace = Stream.NAMESPACE)
public class Stream extends Protocol {

	public final static String NAMESPACE = "http://etherx.jabber.org/streams";

	private final static String XMLNS = "jabber:client";

	private final static String VERSION = "1.0";

	private List<Feature> features;

	@XmlAttribute
	public String getXmlns() {
		return XMLNS;
	}

	@XmlAttribute
	public String getVersion() {
		return VERSION;
	}

	public Stream addFeature(Feature feature) {
		if (this.features == null) {
			this.features = new ArrayList<Feature>();
		}
		this.features.add(feature);
		return this;
	}

	@XmlElementWrapper(namespace = Stream.NAMESPACE, name = "features")
	@XmlElements({ @XmlElement(name = "auth", type = Auth.class), @XmlElement(name = "mechanisms", type = Mechanisms.class), @XmlElement(name = "bind", type = Bind.class), @XmlElement(name = "session", type = Session.class) })
	public List<Feature> getFeatures() {
		return features;
	}

	public static Stream generate(Protocol protocol) {
		return new StreamOpen(protocol);
	}

	@XmlRootElement(name = "stream", namespace = Stream.NAMESPACE)
	public static class StreamOpen extends Stream implements WriteWithOutClose {

		public StreamOpen() {
		}

		public StreamOpen(Protocol protocol) {
			super.setId(protocol.getId());
		}
	}
}
