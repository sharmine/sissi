package com.sissi.relation;

import java.util.Set;

import com.sissi.context.JID;

/**
 * @author kim 2013-11-13
 */
public interface RelationContext {

	public void establish(JID from, Relation relation);

	public void update(JID from, JID to, String state);

	public void remove(JID from, JID to);

	public Relation ourRelation(JID from, JID to);

	public Set<Relation> myRelations(JID from);

	public Set<String> whoSubscribedMe(JID from);

	public Set<String> iSubscribedWho(JID from);
}