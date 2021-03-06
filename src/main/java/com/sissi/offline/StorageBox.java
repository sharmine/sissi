package com.sissi.offline;

import java.util.List;

import com.sissi.context.JID;
import com.sissi.protocol.Element;

/**
 * @author kim 2013-11-15
 */
public interface StorageBox {

	public List<Element> fetch(JID jid);

	public void store(Element element);
}
