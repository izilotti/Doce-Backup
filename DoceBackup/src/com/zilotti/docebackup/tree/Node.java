/*
 * Copyright 2012 Ivan Zilotti Alencar <ialencar@zilotti.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zilotti.docebackup.tree;

import java.util.List;

/**
 * N-Ary tree node.
 * 
 * @author Ivan
 * @param <P> Payload type.
 */
public class Node<P> {

	/** Payload */
	private P payload;
	
	/** Parent */
	private Node<P> parent;
	
	/** Children */
	private List<Node<P>> children;
	
	public Node(P payload) {
		super();
		this.payload = payload;
	}

	public P getPayload() {
		return payload;
	}

	public void setPayload(P payload) {
		this.payload = payload;
	}

	public Node<P> getParent() {
		return parent;
	}

	public void setParent(Node<P> parent) {
		this.parent = parent;
	}

	public List<Node<P>> getChildren() {
		return children;
	}

	public void setChildren(List<Node<P>> children) {
		this.children = children;
	}
}
