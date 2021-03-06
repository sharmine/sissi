package com.sissi.offline.impl;

import java.util.HashMap;
import java.util.Map;

import com.sissi.context.JID.JIDBuilder;
import com.sissi.offline.Storage;
import com.sissi.protocol.Element;

/**
 * @author kim 2013-11-15
 */
public abstract class ProtocolStorage implements Storage {

	private JIDBuilder jidBuilder;

	public ProtocolStorage(JIDBuilder jidBuilder) {
		super();
		this.jidBuilder = jidBuilder;
	}

	protected Element based(Map<String, Object> storage, Element element) {
		return element.setId(this.toString(storage, "id")).setFrom(this.toString(storage, "from")).setTo(this.toString(storage, "to")).setType(this.toString(storage, "type"));
	}

	protected Map<String, Object> based(Element element) {
		Map<String, Object> entity = new HashMap<String, Object>();
		entity.put("id", element.getId());
		entity.put("from", this.jidBuilder.build(element.getFrom()).asStringWithBare());
		entity.put("to", this.jidBuilder.build(element.getTo()).asStringWithBare());
		entity.put("type", element.getType());
		entity.put("class", element.getClass().getSimpleName());
		return entity;
	}

	protected String toString(Map<String, Object> storage, String key) {
		Object value = storage.get(key);
		return value != null ? value.toString() : null;
	}
}