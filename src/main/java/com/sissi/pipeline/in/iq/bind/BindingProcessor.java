package com.sissi.pipeline.in.iq.bind;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.UtilProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.Protocol.Type;
import com.sissi.protocol.iq.IQ;
import com.sissi.protocol.iq.login.Bind;

/**
 * @author kim 2013-10-29
 */
public class BindingProcessor extends UtilProcessor {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		context.write(this.prepareResponse(protocol, this.binding(context, Bind.class.cast(protocol))));
		return true;
	}

	private IQ prepareResponse(Protocol protocol, Bind bind) {
		IQ response = (IQ) protocol.getParent().reply().setType(Type.RESULT).clear();
		return response.add(bind);
	}

	private Bind binding(JIDContext context, Bind bind) {
		if (bind.hasResource()) {
			context.getJid().setResource(bind.getResource().getText());
		}
		return bind.clear().setJid(context.getJid().asString());
	}
}
