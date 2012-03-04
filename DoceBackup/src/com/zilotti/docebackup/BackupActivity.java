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
package com.zilotti.docebackup;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * TODO:
 * Use the observer design pattern to allow status and progress reporting to Main/UI. 
 * 
 * @author Ivan Zilotti Alencar
 *
 * @param <S> Type of the Source Location.
 * @param <D> Type of the Destination Location.
 */
public abstract class BackupActivity<S extends Location<?>, D extends Location<?>> extends Observable {
	
	/** Source location */
	private S sourceLocation;
	
	/** Destination location */
	private D destinationLocation;
	
	/** Observer List */
	private List<Observer> observerList;
	
	/** Synchronizes the destination location with the source location. */
	public abstract void synchronize();
	
	public void addObserver(Observer aStatusObserver) {
		if(observerList == null)
			observerList = new ArrayList<Observer>();
		this.observerList.add(aStatusObserver);
	}
	
	public void removeObserver(Observer aStatusObserver) {
		if(this.observerList != null)
			this.observerList.remove(aStatusObserver);
	}
	
	public S getSourceLocation() {
		return sourceLocation;
	}
	public void setSourceLocation(S sourceLocation) {
		this.sourceLocation = sourceLocation;
	}
	public D getDestinationLocation() {
		return destinationLocation;
	}
	public void setDestinationLocation(D destinationLocation) {
		this.destinationLocation = destinationLocation;
	}
}
