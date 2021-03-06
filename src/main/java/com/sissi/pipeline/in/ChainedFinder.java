package com.sissi.pipeline.in;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sissi.context.JID.JIDBuilder;
import com.sissi.pipeline.Input;
import com.sissi.pipeline.Input.InputCondition;
import com.sissi.protocol.Protocol;

/**
 * @author kim 2013-11-4
 */
public class ChainedFinder extends JIDWrapFinder {

	private final Log log = LogFactory.getLog(this.getClass());

	private List<InputCondition> conditions;

	public ChainedFinder(JIDBuilder jidBuilder, List<InputCondition> conditions) {
		super(jidBuilder);
		this.conditions = conditions;
	}

	@Override
	public Input doFind(Protocol protocol) {
		for (InputCondition each : this.conditions) {
			if (each.getMatcher().match(protocol)) {
				return each.getInput();
			}
		}
		this.log.warn("None Input can process " + protocol.getClass());
		return NothingProcessor.NOTHING;
	}
}
